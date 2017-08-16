package com.czy.qcloud.face.service.impl;

import com.czy.qcloud.face.entity.Face;
import com.czy.qcloud.face.model.*;
import com.czy.qcloud.face.repository.FaceRepository;
import com.czy.qcloud.face.service.PersonManagementService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qcloud.image.request.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class PersonManagementServiceImpl extends FaceService implements PersonManagementService {

    private static final Logger logger = LoggerFactory.getLogger(PersonManagementServiceImpl.class);

    @Autowired
    private Gson gson;

    @Autowired
    private FaceRepository faceRepository;

    @Override
    public Result<List<Person>> queryAllPersonInfo() {
        Result<PersonIds> personIdsResult = queryPersonIds(GROUP);
        Result<List<Person>> result = new Result<>();
        List<Person> people = new ArrayList<>();
        result.setData(people);
        result.setCode(0);
        result.setMessage("OK");
        if (Objects.equals(0, personIdsResult.getCode())) {
            personIdsResult.getData().getPerson_ids().forEach(personId -> {
                Result<PersonItem> personItemResult = queryPersonItem(personId);
                if (Objects.equals(0, personItemResult.getCode())) {
                    Person person = new Person();
                    person.setFace_ids(personItemResult.getData().getFace_ids());
                    person.setGroup_ids(personItemResult.getData().getGroup_ids());
                    person.setPerson_id(personItemResult.getData().getPerson_id());
                    person.setPerson_name(personItemResult.getData().getPerson_name());
                    person.setSession_id(personItemResult.getData().getSession_id());
                    person.setFace_urls(new ArrayList<>(personItemResult.getData().getFace_ids().size()));
                    personItemResult.getData().getFace_ids().forEach(faceId -> {
                        Face face = faceRepository.findFirstByFaceId(faceId);
                        person.getFace_urls().add(face == null ? "" : face.getFaceUrl());
                    });
                    people.add(person);
                }
            });
        }
        return result;
    }

    @Override
    public Result<Create> createPerson(String personName, String faceUrl) {
        FaceNewPersonRequest personNewReq = new FaceNewPersonRequest(BUCKET_NAME, UUID.randomUUID().toString(), new String[]{GROUP}, faceUrl, personName, "");
        String ret = imageClient.faceNewPerson(personNewReq);
        logger.info("person new ret:" + ret);
        Result<Create> result = gson.fromJson(ret, new TypeToken<Result<Create>>() {
        }.getType());
        if (Objects.equals(result.getCode(), 0)) {
            Face face = new Face();
            face.setFaceId(result.getData().getFace_id());
            face.setFaceUrl(faceUrl);
            faceRepository.save(face);
        }
        return result;
    }

    @Override
    public Result<DropPerson> dropPerson(String personId) {
        FaceDelPersonRequest delPersonReq = new FaceDelPersonRequest(BUCKET_NAME, personId);
        String ret = imageClient.faceDelPerson(delPersonReq);
        logger.info("face del person ret:" + ret);
        Result<DropPerson> result = gson.fromJson(ret, new TypeToken<Result<DropPerson>>() {
        }.getType());
        return result;
    }

    @Override
    public Result<AddFace> addFace(String personId, String faceUrl) {
        FaceAddFaceRequest addFaceReq = new FaceAddFaceRequest(BUCKET_NAME, new String[]{faceUrl}, personId, "");
        String ret = imageClient.faceAddFace(addFaceReq);
        logger.info("add face ret:" + ret);
        Result<AddFace> result = gson.fromJson(ret, new TypeToken<Result<AddFace>>() {
        }.getType());
        if (Objects.equals(0, result.getCode())) {
            Face face = new Face();
            face.setFaceUrl(faceUrl);
            face.setFaceId(result.getData().getFace_ids().get(0));
            faceRepository.save(face);
        }
        return result;
    }

    @Override
    public Result<DelFace> delFace(String personId, String faceId) {
        FaceDelFaceRequest delFaceReq = new FaceDelFaceRequest(BUCKET_NAME, personId, new String[]{faceId});
        String ret = imageClient.faceDelFace(delFaceReq);
        logger.info("face del ret:" + ret);
        Result<DelFace> result = gson.fromJson(ret, new TypeToken<Result<DelFace>>() {
        }.getType());
        if (Objects.equals(0, result.getCode())) {
            faceRepository.deleteByFaceId(faceId);
        }
        return result;
    }

    @Override
    public String identifyPerson(String faceUrl) {
        FaceIdentifyRequest faceIdentifyReq = new FaceIdentifyRequest(BUCKET_NAME, GROUP, faceUrl);
        String ret = imageClient.faceIdentify(faceIdentifyReq);
        logger.info("face identify ret:" + ret);
        Result<IdentifyPerson> result = gson.fromJson(ret, new TypeToken<Result<IdentifyPerson>>() {
        }.getType());
        if (Objects.equals(0, result.getCode())) {
            if (result.getData().getCandidates().size() == 0) {
                return "未发现匹配人物";
            }
            Result<PersonItem> personItemResult = queryPersonItem(result.getData().getCandidates().get(0).getPerson_id());
            if (!Objects.equals(0, personItemResult.getCode())) {
                return "查询人物信息失败";
            }
            Float confidence = result.getData().getCandidates().get(0).getConfidence();
            return confidence.intValue() + "%" + "可能是" + personItemResult.getData().getPerson_name();
        }
        return "识别人物失败";
    }

    private Result<PersonIds> queryPersonIds(String group) {
        FaceGetPersonIdsRequest getPersonIdsReq = new FaceGetPersonIdsRequest(BUCKET_NAME, group);
        String ret = imageClient.faceGetPersonIds(getPersonIdsReq);
        logger.info("face get person ids ret:" + ret);
        return gson.fromJson(ret, new TypeToken<Result<PersonIds>>() {
        }.getType());
    }

    private Result<FaceIds> queryFaceIds(String personId) {
        FaceGetFaceIdsRequest getFaceIdsReq = new FaceGetFaceIdsRequest(BUCKET_NAME, personId);
        String ret = imageClient.faceGetFaceIds(getFaceIdsReq);
        logger.info("face get face ids ret:" + ret);
        return gson.fromJson(ret, new TypeToken<Result<FaceIds>>() {
        }.getType());
    }

    private Result<FaceItem> queryFaceItem(String faceId) {
        FaceGetFaceInfoRequest getFaceInfoReq = new FaceGetFaceInfoRequest(BUCKET_NAME, faceId);
        String ret = imageClient.faceGetFaceInfo(getFaceInfoReq);
        logger.info("face get faceItem info ret:" + ret);
        return gson.fromJson(ret, new TypeToken<Result<FaceItem>>() {
        }.getType());
    }

    private Result<PersonItem> queryPersonItem(String personId) {
        FaceGetInfoRequest getInfoReq = new FaceGetInfoRequest(BUCKET_NAME, personId);
        String ret = imageClient.faceGetInfo(getInfoReq);
        logger.info("face get personItem ret:" + ret);
        return gson.fromJson(ret, new TypeToken<Result<PersonItem>>() {
        }.getType());
    }
}

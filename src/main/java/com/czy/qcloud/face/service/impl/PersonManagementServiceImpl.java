package com.czy.qcloud.face.service.impl;

import com.czy.qcloud.face.model.FaceIds;
import com.czy.qcloud.face.model.PersonIds;
import com.czy.qcloud.face.model.Result;
import com.czy.qcloud.face.service.PersonManagementService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qcloud.image.request.FaceGetFaceIdsRequest;
import com.qcloud.image.request.FaceGetPersonIdsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PersonManagementServiceImpl extends FaceService implements PersonManagementService {

    private static final Logger logger = LoggerFactory.getLogger(PersonManagementServiceImpl.class);

    @Autowired
    private Gson gson;

    @Override
    public String queryAllPersonInfo() {
        Result<PersonIds> personIdsResult = queryPersonIds(GROUP);

        if (Objects.equals(0, personIdsResult.getCode())) {
            personIdsResult.getData().getPerson_ids().forEach(personId -> {
                Result<FaceIds> faceIdsResult = queryFaceIds(personId);
                if(Objects.equals(0,faceIdsResult.getCode())){
                    faceIdsResult.getData().getFace_ids().forEach(faceId -> {

                    });
                }
            });
        }

        String getFacePersonId = "personY";

        return null;
    }

    private Result<PersonIds> queryPersonIds(String group) {
        FaceGetPersonIdsRequest getPersonIdsReq = new FaceGetPersonIdsRequest(BUCKET_NAME, group);
        String ret = imageClient.faceGetPersonIds(getPersonIdsReq);
        logger.info("face get person ids  ret:" + ret);
        return gson.fromJson(ret, new TypeToken<Result<PersonIds>>() {
        }.getType());
    }

    private Result<FaceIds> queryFaceIds(String personId) {
        FaceGetFaceIdsRequest getFaceIdsReq = new FaceGetFaceIdsRequest(BUCKET_NAME, personId);
        String ret = imageClient.faceGetFaceIds(getFaceIdsReq);
        logger.info("face get face ids  ret:" + ret);
        return gson.fromJson(ret, new TypeToken<Result<FaceIds>>() {
        }.getType());
    }
}

package com.czy.qcloud.face.service;

import com.czy.qcloud.face.model.*;

import java.util.List;

public interface PersonManagementService {
    Result<List<Person>> queryAllPersonInfo();

    Result<Create> createPerson(String personName,String faceUrl);

    Result<DropPerson> dropPerson(String personId);

    Result<AddFace> addFace(String personId, String faceUrl);

    Result<DelFace> delFace(String personId, String faceId);

    String identifyPerson(String faceUrl);
}
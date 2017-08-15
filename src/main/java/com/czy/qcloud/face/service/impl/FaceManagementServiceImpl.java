package com.czy.qcloud.face.service.impl;

import com.czy.qcloud.face.entity.Face;
import com.czy.qcloud.face.repository.FaceRepository;
import com.czy.qcloud.face.service.FaceManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaceManagementServiceImpl extends FaceService implements FaceManagementService {

    private static final Logger logger = LoggerFactory.getLogger(FaceManagementServiceImpl.class);

    @Autowired
    private FaceRepository faceRepository;

    @Override
    public boolean addFace(String faceId, String faceUrl) {
        if (faceId.isEmpty() || faceUrl.isEmpty()) {
            return false;
        }
        Face face = new Face();
        face.setFaceId(faceId);
        face.setFaceUrl(faceUrl);
        faceRepository.save(face);
        return true;
    }
}

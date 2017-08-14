package com.czy.qcloud.face.service.impl;

import com.czy.qcloud.face.service.FaceCompareService;
import com.qcloud.image.request.FaceCompareRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FaceCompareServiceImpl extends FaceService implements FaceCompareService {

    private static final Logger logger = LoggerFactory.getLogger(FaceCompareServiceImpl.class);

    @Override
    public String compare(String urlA, String urlB) {
        FaceCompareRequest faceCompareReq = new FaceCompareRequest(BUCKET_NAME, urlA, urlB);
        return imageClient.faceCompare(faceCompareReq);
    }
}

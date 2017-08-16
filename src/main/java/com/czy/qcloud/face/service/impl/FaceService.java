package com.czy.qcloud.face.service.impl;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.sign.Credentials;
import com.qcloud.image.ImageClient;

public abstract class FaceService {
    protected static final int APP_ID = 1253953328;
    protected static final String SECRET_ID = "AKIDoW4QcbT0PcecUBeSAg083pOkurtmIhaI";
    protected static final String SECRET_KEY = "jGbkhJp8JI4e4ISgvhDkIjy1vd8QXR4l";
    protected static final String BUCKET_NAME = "test";
    protected static final ImageClient imageClient = new ImageClient(APP_ID, SECRET_ID, SECRET_KEY);
    protected static final String GROUP = "testGroup";

    protected static final Credentials credentials = new Credentials(APP_ID, SECRET_ID, SECRET_KEY);
    protected static final ClientConfig clientConfig = new ClientConfig();
    protected static final COSClient cosClient = new COSClient(clientConfig, credentials);

    static {
        clientConfig.setRegion("gz");
    }
}

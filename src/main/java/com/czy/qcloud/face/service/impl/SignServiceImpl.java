package com.czy.qcloud.face.service.impl;

import com.czy.qcloud.face.service.SignService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.exception.AbstractCosException;
import com.qcloud.cos.sign.Credentials;
import com.qcloud.cos.sign.Sign;
import org.springframework.stereotype.Service;

@Service
public class SignServiceImpl implements SignService {
    private static final long APP_ID = 1253953328;
    private static final String SECRET_ID = "AKIDoW4QcbT0PcecUBeSAg083pOkurtmIhaI";
    private static final String SECRET_KEY = "jGbkhJp8JI4e4ISgvhDkIjy1vd8QXR4l";
    private static final String BUCKET_NAME = "test";

    private static final Credentials credentials = new Credentials(APP_ID, SECRET_ID, SECRET_KEY);
    private static final ClientConfig clientConfig = new ClientConfig();
    private static final COSClient cosClient = new COSClient(clientConfig, credentials);

    private static final long EXPIRED = 5 * 60;

    static {
        clientConfig.setRegion("gz");
    }


    @Override
    public String getOnceSign() throws AbstractCosException {
        return Sign.getOneEffectiveSign(BUCKET_NAME, "", credentials);
    }

    @Override
    public String getSign() throws AbstractCosException {
        return Sign.getPeriodEffectiveSign(BUCKET_NAME, "", credentials, (System.currentTimeMillis() / 1000) + EXPIRED);
    }

    @Override
    public String getDownLoadSign() throws AbstractCosException {
        return Sign.getDownLoadSign(BUCKET_NAME, "", credentials, (System.currentTimeMillis() / 1000) + EXPIRED);
    }
}

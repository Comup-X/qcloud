package com.czy.qcloud.face.service.impl;

import com.czy.qcloud.face.service.SignService;
import com.qcloud.cos.exception.AbstractCosException;
import com.qcloud.cos.sign.Sign;
import org.springframework.stereotype.Service;

@Service
public class SignServiceImpl extends FaceService implements SignService {

    private static final long EXPIRED = 5 * 60;

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

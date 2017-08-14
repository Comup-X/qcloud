package com.czy.qcloud.face.service;

import com.qcloud.cos.exception.AbstractCosException;

public interface SignService {

    String getOnceSign() throws AbstractCosException;

    String getSign() throws AbstractCosException;

    String getDownLoadSign() throws AbstractCosException;
}

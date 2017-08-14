package com.czy.qcloud.face.controller;

import com.czy.qcloud.face.service.SignService;
import com.qcloud.cos.exception.AbstractCosException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign")
public class SignController {

    private static final Logger logger = LoggerFactory.getLogger(SignController.class);

    @Autowired
    private SignService signService;

    @CrossOrigin
    @GetMapping("/sign")
    public String sign() {
        try {
            return signService.getSign();
        } catch (AbstractCosException e) {
            logger.error("sign error", e);
            return "";
        }
    }

    @CrossOrigin
    @GetMapping("/onceSign")
    public String onceSign() {
        try {
            return signService.getOnceSign();
        } catch (AbstractCosException e) {
            logger.error("onceSign error", e);
            return "";
        }
    }
}

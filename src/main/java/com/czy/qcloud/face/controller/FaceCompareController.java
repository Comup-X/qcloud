package com.czy.qcloud.face.controller;

import com.czy.qcloud.face.service.FaceCompareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/faceCompare")
public class FaceCompareController {

    private static final Logger logger = LoggerFactory.getLogger(FaceCompareController.class);

    @Autowired
    private FaceCompareService faceCompareService;

    @CrossOrigin
    @PostMapping("/compare")
    public String compare(@RequestBody Map<String, Object> json) {
        String compare = faceCompareService.compare(json.get("urlA").toString(), json.get("urlB").toString());
        logger.info("compare result is:{}", compare);
        return compare;
    }

}
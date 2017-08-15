package com.czy.qcloud.face.controller;

import com.czy.qcloud.face.service.FaceManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/face")
public class FaceManagementController {

    private static final Logger logger = LoggerFactory.getLogger(FaceManagementController.class);

    @Autowired
    private FaceManagementService faceManagementService;

    @CrossOrigin
    @RequestMapping("/add")
    public boolean add(@RequestBody Map<String, Object> params) {
        return faceManagementService.addFace(params.get("faceId").toString(), params.get("faceUrl").toString());
    }
}

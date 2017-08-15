package com.czy.qcloud.face.controller;

import com.czy.qcloud.face.service.PersonManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonManagementController {

    @Autowired
    private PersonManagementService personManagementService;

    @RequestMapping("/")
    public String listAll() {
        return personManagementService.queryAllPersonInfo();
    }
}

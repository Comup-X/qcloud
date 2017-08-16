package com.czy.qcloud.face.controller;

import com.czy.qcloud.face.model.AddFace;
import com.czy.qcloud.face.model.Create;
import com.czy.qcloud.face.model.Person;
import com.czy.qcloud.face.model.Result;
import com.czy.qcloud.face.service.PersonManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonManagementController {

    @Autowired
    private PersonManagementService personManagementService;

    @CrossOrigin
    @RequestMapping("")
    public Result<List<Person>> listAll() {
        return personManagementService.queryAllPersonInfo();
    }

    @CrossOrigin
    @RequestMapping("/create")
    public Result<Create> createPerson(String personName, String faceUrl) {
        return personManagementService.createPerson(personName, faceUrl);
    }

    @CrossOrigin
    @RequestMapping("/addFace")
    public Result<AddFace> addFace(@RequestBody Map<String, Object> params) {
        return personManagementService.addFace(params.get("personId").toString(), params.get("faceUrl").toString());
    }
}
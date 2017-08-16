package com.czy.qcloud.face.controller;

import com.czy.qcloud.face.model.AddFace;
import com.czy.qcloud.face.model.Create;
import com.czy.qcloud.face.model.Person;
import com.czy.qcloud.face.model.Result;
import com.czy.qcloud.face.service.PersonManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/create")
    public Result<Create> createPerson(@RequestBody Map<String, Object> params) {
        return personManagementService.createPerson(params.get("name").toString(), params.get("faceUrl").toString());
    }

    @CrossOrigin
    @PutMapping("/addFace")
    public Result<AddFace> addFace(@RequestBody Map<String, Object> params) {
        return personManagementService.addFace(params.get("personId").toString(), params.get("faceUrl").toString());
    }

    @CrossOrigin
    @GetMapping("/identifyPerson")
    public String identifyPerson(String faceUrl) {
        return personManagementService.identifyPerson(faceUrl);
    }
}
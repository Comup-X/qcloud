package com.czy.qcloud.face;

import com.czy.qcloud.face.service.PersonManagementService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QcloudFaceApplicationTests {

    @Autowired
    private PersonManagementService personManagementService;
    @Autowired
    private Gson gson;

    private String one = "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=390549859,3002632895&fm=200&gp=0.jpg";
    private String two = "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1589054647,3907483770&fm=200&gp=0.jpg";

    @Test
    public void createPerson() {
        System.out.println(gson.toJson(personManagementService.createPerson("zy", one)));
    }

    @Test
    public void dropPerson(){
        personManagementService.dropPerson("bcf562ef-01e2-45ea-9755-c477ef15a07c");
    }

    @Test
    public void addFace() {
        System.out.println(gson.toJson(personManagementService.addFace("bcf562ef-01e2-45ea-9755-c477ef15a07c", two)));
    }

    @Test
    public void queryAllPersonInfo() {
        System.out.println(gson.toJson(personManagementService.queryAllPersonInfo()));
    }

    @Test
    public void identifyPerson(){
        System.out.println(gson.toJson(personManagementService.identifyPerson(one)));
    }
}
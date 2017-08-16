package com.czy.qcloud.face.model;

import java.util.List;

public class Person extends PersonItem{
    private List<String> face_urls;

    public List<String> getFace_urls() {
        return face_urls;
    }

    public void setFace_urls(List<String> face_urls) {
        this.face_urls = face_urls;
    }
}

package com.czy.qcloud.face.model;

public class IdentifyItem {
    //	候选者person_id
    private String person_id;
    //候选者face_id
    private String face_id;
    //候选者的置信度
    private Float confidence;
    //人脸备注信息
    private String tag;

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getFace_id() {
        return face_id;
    }

    public void setFace_id(String face_id) {
        this.face_id = face_id;
    }

    public Float getConfidence() {
        return confidence;
    }

    public void setConfidence(Float confidence) {
        this.confidence = confidence;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}

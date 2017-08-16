package com.czy.qcloud.face.model;

import java.util.List;

public class Create {
    private String session_id;
    private Integer suc_group;
    private Integer suc_face;
    private String person_id;
    private String face_id;
    private List<String> group_ids;

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public Integer getSuc_group() {
        return suc_group;
    }

    public void setSuc_group(Integer suc_group) {
        this.suc_group = suc_group;
    }

    public Integer getSuc_face() {
        return suc_face;
    }

    public void setSuc_face(Integer suc_face) {
        this.suc_face = suc_face;
    }

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

    public List<String> getGroup_ids() {
        return group_ids;
    }

    public void setGroup_ids(List<String> group_ids) {
        this.group_ids = group_ids;
    }
}

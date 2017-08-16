package com.czy.qcloud.face.model;

import java.util.List;

public class DelFace {
    //相应请求的session标识符
    private String session_id;
    //成功删除的face数量
    private Integer deleted;
    //成功删除的face_id列表
    private List<String> face_ids;

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public List<String> getFace_ids() {
        return face_ids;
    }

    public void setFace_ids(List<String> face_ids) {
        this.face_ids = face_ids;
    }
}

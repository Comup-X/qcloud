package com.czy.qcloud.face.model;

public class DropPerson {
    //相应请求的session标识符
    private String session_id;
    //成功删除的person_id
    private String person_id;
    //成功删除的Person数量
    private Integer deleted;

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}

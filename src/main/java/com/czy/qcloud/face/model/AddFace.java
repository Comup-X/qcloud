package com.czy.qcloud.face.model;

import java.util.List;

public class AddFace {
    private String session_id;
    private Integer added;
    private List<String> face_ids;
    private List<Integer> ret_codes;

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public Integer getAdded() {
        return added;
    }

    public void setAdded(Integer added) {
        this.added = added;
    }

    public List<String> getFace_ids() {
        return face_ids;
    }

    public void setFace_ids(List<String> face_ids) {
        this.face_ids = face_ids;
    }

    public List<Integer> getRet_codes() {
        return ret_codes;
    }

    public void setRet_codes(List<Integer> ret_codes) {
        this.ret_codes = ret_codes;
    }
}

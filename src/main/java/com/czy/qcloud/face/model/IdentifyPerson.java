package com.czy.qcloud.face.model;

import java.util.List;

public class IdentifyPerson {
    //相应请求的session标识符，可用于结果查询
    private String session_id;
    //识别出的top5候选人
    private List<IdentifyItem> candidates;

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public List<IdentifyItem> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<IdentifyItem> candidates) {
        this.candidates = candidates;
    }
}

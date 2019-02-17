package com.hanwu.hill.response;

public interface Response {

    void setRegion(String region);

    void setAzone(String azone);

    void setRequestTime();

    void setSuccess(boolean Success);
}

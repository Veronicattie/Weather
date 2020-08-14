package com.example.weather2.module;

public class BaseData {
    //结果码
    private int rcode;
    //结果描述
    private String rdesc;


    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }
    public String getRdesc() {
        return rdesc;
    }

    public void setRcode(int rcode) {
        this.rcode = rcode;
    }
    public int getRcode() {
        return rcode;
    }

}

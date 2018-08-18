package com.vince;

import java.io.Serializable;

public class Message implements Serializable {
    private String from;
    private String info;
    private int type;

    public Message() {
    }

    public Message(String from, String info, int type) {
        this.from = from;
        this.info = info;
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

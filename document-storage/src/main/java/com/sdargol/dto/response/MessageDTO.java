package com.sdargol.dto.response;

public class MessageDTO {
    private String msg;

    public MessageDTO() {
    }

    public MessageDTO(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

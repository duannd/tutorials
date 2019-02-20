package com.duannd.core.models;

import lombok.Data;

/**
 * Created By ngdduan@gmail.com at 2/20/2019 2:52 PM
 */
@Data
public class Message {

    private String msg;

    public Message(String msg) {
        this.msg = msg;
    }

}

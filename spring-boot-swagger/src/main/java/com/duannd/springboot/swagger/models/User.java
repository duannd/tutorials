package com.duannd.springboot.swagger.models;

import lombok.Data;

import java.util.Date;

/**
 * Created By duan.nd@senseinfosys.com at 10/5/2018 4:09 PM
 */
@Data
public class User {
    private String id;
    private String username;
    private String name;
    private Date birthday;

    public User() {
    }

    public User(String id) {
        this.id = id;
    }
}

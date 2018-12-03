package com.duannd.springboot.caching.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created By ngdduan@gmail.com at 12/3/2018 2:49 PM
 */
@Getter
@Setter
@Data
public class User implements Serializable {

    private Integer id;
    private String firstName;
    private String lastName;

    public User() {

    }

    public User(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}

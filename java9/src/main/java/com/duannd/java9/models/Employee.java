package com.duannd.java9.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "name"})
public class Employee {

    private int id;
    private String name;

}

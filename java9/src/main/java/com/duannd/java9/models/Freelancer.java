package com.duannd.java9.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Freelancer extends Employee {

    private int fid;

    public Freelancer(int id, String name, int fid) {
        super(id, name);
        this.fid = fid;
    }
}

package com.duannd.fundamental;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameEntry {

    private String name;
    private int score;

    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "GameEntry{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

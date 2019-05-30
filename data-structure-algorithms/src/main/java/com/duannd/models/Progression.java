package com.duannd.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Progression {

    protected long current;

    public Progression() {
        this(0);
    }

    public Progression(long start) {
        this.current = start;
    }

    public long nextValue() {
        var answer = this.current;
        advance();
        return answer;
    }

    protected void advance() {
        this.current++;
    }

    public void printProgression(int n) {
        System.out.print(nextValue());
        for (var i = 0; i < n; i++) {
            System.out.print(" " + nextValue());
        }
        System.out.println();
    }

}

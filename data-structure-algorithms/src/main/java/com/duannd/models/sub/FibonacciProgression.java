package com.duannd.models.sub;

import com.duannd.models.Progression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FibonacciProgression extends Progression {

    protected long prev;

    public FibonacciProgression() {
        this(0, 1);
    }

    public FibonacciProgression(long first, long second) {
        super(first);
        this.prev = second - first;
    }

    @Override
    protected void advance() {
        long temp = this.prev; // fn-2
        this.prev = this.current; // fn-1
        this.current = this.prev + temp; // fn = fn-1 + fn-2
    }



}

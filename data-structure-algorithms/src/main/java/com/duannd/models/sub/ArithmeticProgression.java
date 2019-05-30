package com.duannd.models.sub;

import com.duannd.models.Progression;

public class ArithmeticProgression extends Progression {

    protected long increment;

    public ArithmeticProgression() {
        this(1, 0);
    }

    public ArithmeticProgression(long stepSize) {
        this(stepSize, 0);
    }

    public ArithmeticProgression(long stepSize, long start) {
        super(start);
        this.increment = stepSize;
    }

    @Override
    protected void advance() {
        this.current += this.increment;
    }


}

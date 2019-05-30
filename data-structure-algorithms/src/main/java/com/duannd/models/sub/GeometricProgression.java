package com.duannd.models.sub;

import com.duannd.models.Progression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeometricProgression extends Progression {

    protected long base;

    public GeometricProgression() {
        this(2);
    }

    public GeometricProgression(long base) {
        this(base, 1);
    }

    public GeometricProgression(long base, long start) {
        super(start);
        this.base = base;
    }

    @Override
    protected void advance() {
        this.current *= base;
    }

}

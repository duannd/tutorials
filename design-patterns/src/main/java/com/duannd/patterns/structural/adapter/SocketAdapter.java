package com.duannd.patterns.structural.adapter;

import com.duannd.patterns.structural.models.Volt;

public interface SocketAdapter {

    Volt get120Volt();

    Volt get12Volt();

    Volt get3Volt();

    default Volt convertVolt(Volt origin, int divide) {
        return new Volt(origin.getVolts() / divide);
    }

}

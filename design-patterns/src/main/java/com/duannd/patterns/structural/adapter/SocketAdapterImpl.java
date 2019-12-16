package com.duannd.patterns.structural.adapter;

import com.duannd.patterns.structural.models.Socket;
import com.duannd.patterns.structural.models.Volt;

public class SocketAdapterImpl extends Socket implements SocketAdapter {

    @Override
    public Volt get120Volt() {
        return getVolt();
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(getVolt(), 10);
    }

    @Override
    public Volt get3Volt() {
        return convertVolt(getVolt(), 40);
    }

}

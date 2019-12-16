package com.duannd.patterns.structural.adapter;

import com.duannd.patterns.structural.models.Socket;
import com.duannd.patterns.structural.models.Volt;

public class SocketObjectAdapterImpl implements SocketAdapter {

    //Using Composition for adapter pattern
    private final Socket socket = new Socket();

    @Override
    public Volt get120Volt() {
        return socket.getVolt();
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(socket.getVolt(), 10);
    }

    @Override
    public Volt get3Volt() {
        return convertVolt(socket.getVolt(), 40);
    }

}

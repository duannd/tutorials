package com.duannd.oop;

public class Portfolio<T> {

    private T[] data;

    public Portfolio(int capacity) {
        this.data = (T[]) new Object[capacity];
    }

}

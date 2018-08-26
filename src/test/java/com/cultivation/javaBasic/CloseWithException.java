package com.cultivation.javaBasic;

public class CloseWithException implements AutoCloseable{

    public boolean isClosed = false;

    @Override
    public void close() {
        this.isClosed = true;
        throw new NullPointerException();
    }
}

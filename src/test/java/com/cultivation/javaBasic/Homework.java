package com.cultivation.javaBasic;

import java.util.Iterator;

public class Homework implements Iterator<Integer>, Iterable<Integer>{

    private int number = 0;

    @Override
    public boolean hasNext() {
        number += 1;
        return number < (1 << 4);
    }

    @Override
    public Integer next() {
        return number;
    }

    @Override
    public Iterator<Integer> iterator() {
        return this;
    }
}

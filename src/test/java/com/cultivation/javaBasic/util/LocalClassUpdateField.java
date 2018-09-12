package com.cultivation.javaBasic.util;

public class LocalClassUpdateField {
    private int year;

    public LocalClassUpdateField() {
        year = 2018;
    }

    public int getYear() {
        return year;
    }

    public void somethingHappen() {
        class YearIncrementer {
            private int year;
            private void increment() {
                ++year;
            }
        }

        new YearIncrementer().increment();
    }
}

package com.cultivation.javaBasic.util;

public class InnerClassUpdateField {
    private int year;

    public InnerClassUpdateField(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void add(int year) {
        class InnerClass {
            private static final int year = 2;
        }

        this.new InnerClass(year).add();
    }

    public class InnerClass {
        private static final int y = 2;

        private int year;

        public InnerClass() {
        }

        public InnerClass(int year) {
            this.year = year;
        }

        public void add() {
            InnerClassUpdateField.this.year += this.year;
        }

        public void increment() {
            InnerClassUpdateField.this.year += 1;
        }
    }
}

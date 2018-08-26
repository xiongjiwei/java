package com.cultivation.javaBasic.util;

public class StaticInnerClass {

    public void creat() {
        OutClass.StaticInner.Inner staticInner = new OutClass.StaticInner().new Inner();
    }

    public Inner createInner() {
        return new Inner("Hello");
    }

    public static class Inner {
        private String name;
        public static int i;

        public Inner(String name) {
            this.name = name;
            i++;
        }

        public String getName() {
            return name;
        }
    }
}

class OutClass {
    static class StaticInner {
        class Inner {
            public String getString() {
                return "Hello";
            }
        }
    }
}



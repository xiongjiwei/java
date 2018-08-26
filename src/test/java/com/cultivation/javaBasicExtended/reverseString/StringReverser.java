package com.cultivation.javaBasicExtended.reverseString;

class StringReverser {
    @SuppressWarnings({"WeakerAccess", "unused"})
    public static String[] reverse(String input) {
        // TODO: please implement the method to pass all the tests.
        // <--start
        if (input == null) {
            throw new IllegalArgumentException();
        }

        input = input.trim();

        if (input.length() == 0) {
            return new String[0];
        }

        String[] toReverse = input.split(" ");
        String[] reverses = new String[toReverse.length];

        for (int i = 0; i < reverses.length; i++) {
            reverses[reverses.length - i - 1] = toReverse[i];
        }

        return reverses;
        // --end-->
    }
}

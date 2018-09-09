package com.cultivation.javaBasic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeworkTest {

    @Test
    void should_get_right_size_of_array_list() {
        Homework homework = new Homework();
        ArrayList<Integer> result = new ArrayList<>();

        homework.forEach(result::add);

        assertEquals(15, result.size());
    }


}

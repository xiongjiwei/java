package com.cultivation.javaBasic;

import com.cultivation.javaBasic.util.AnonymousClassUpdateField;
import com.cultivation.javaBasic.util.InnerClassUpdateField;
import com.cultivation.javaBasic.util.LocalClassUpdateField;
import com.cultivation.javaBasic.util.StaticInnerClass;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InnerClassTest {
    @SuppressWarnings("ConstantConditions")
    @Test
    void should_access_instance_field_of_parent_class() {

    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void should_refer_inner_class_from_outside() {
        InnerClassUpdateField innerClassUpdateField = new InnerClassUpdateField(2018);
        InnerClassUpdateField.InnerClass innerClass = innerClassUpdateField.new InnerClass();

        innerClass.increment();

        assertEquals(2019, innerClassUpdateField.getYear());
    }

    @Test
    void should_increment_from_constructor() {
        InnerClassUpdateField innerClassUpdateField = new InnerClassUpdateField(2018);
        InnerClassUpdateField.InnerClass innerClass = innerClassUpdateField.new InnerClass(2);

        assertEquals(2020, innerClassUpdateField.getYear());
    }

    @Test
    void should_increment_after_run_add() {
        InnerClassUpdateField innerClassUpdateField = new InnerClassUpdateField(2018);
        InnerClassUpdateField.InnerClass innerClass = innerClassUpdateField.new InnerClass(2);

        innerClass.add();

        assertEquals(2020, innerClassUpdateField.getYear());
    }

    @Test
    void should_add_from_out_class() {
        InnerClassUpdateField innerClassUpdateField = new InnerClassUpdateField(2018);
        innerClassUpdateField.add(2);

        assertEquals(2020, innerClassUpdateField.getYear());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void should_update_field_using_local_class() {
        LocalClassUpdateField instance = new LocalClassUpdateField();
        instance.somethingHappen();

        // TODO: please modify the following code to pass the test
        // <--start
        final Optional<Integer> expected = Optional.of(2019);
        // --end-->

        assertEquals(expected.get().intValue(), instance.getYear());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void should_update_field_using_anonymous_class() {
        AnonymousClassUpdateField instance = new AnonymousClassUpdateField();
        instance.somethingHappen();

        // TODO: please modify the following code to pass the test
        // <--start
        final Optional<Integer> expected = Optional.of(2019);
        // --end-->

        assertEquals(expected.get().intValue(), instance.getYear());
    }

    @Test
    void should_create_instance_for_static_inner_class() {
        StaticInnerClass instance = new StaticInnerClass();

        StaticInnerClass.Inner inner = instance.createInner();

        StaticInnerClass.Inner inner1 = new StaticInnerClass.Inner("World");

        // TODO: please modify the following code to pass the test
        // <--start
        final String expected = "Hello";
        // --end-->

        assertEquals(expected, inner.getName());
        assertEquals("World", inner1.getName());
    }
}

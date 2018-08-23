package com.cultivation.javaBasic;

import com.cultivation.javaBasic.util.Employee;
import com.cultivation.javaBasic.util.MethodWithAnnotation;
import com.cultivation.javaBasic.util.MyAnnotation;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReflectionTest {
    @Test
    void should_be_able_to_get_class_object() {
        Employee employee = new Employee();
        Class<? extends Employee> employeeClass = employee.getClass();

        // TODO: please modify the following code to pass the test
        // <--start
        final Class<? extends Employee> expected = Employee.class;
        // --end-->

        assertEquals(expected, employeeClass);
    }

    @Test
    void should_be_able_to_get_full_qualified_name() {
        Employee employee = new Employee();
        Class<? extends Employee> employeeClass = employee.getClass();

        // TODO: please modify the following code to pass the test
        // <--start
        final String expected = "com.cultivation.javaBasic.util.Employee";
        // --end-->

        assertEquals(expected, employeeClass.getName());
    }

    @SuppressWarnings({"ConstantConditions", "unused"})
    @Test
    void should_be_able_to_instantiate_types_at_runtime() throws Exception {
        Class<?> theClass = Class.forName("com.cultivation.javaBasic.util.Employee");

        // TODO: please created an instance described by `theClass`
        // <--start
        Employee instance = (Employee) theClass.newInstance();
        // --end-->

        assertEquals("Employee", instance.getTitle());
    }

    @SuppressWarnings({"ConstantConditions", "unused"})
    @Test
    void should_be_able_to_print_all_static_methods_of_double() {
        Class<Double> doubleClass = Double.class;

        // TODO: please get all public static declared methods of Double. Sorted in an ascending order
        // <--start

        Method[] declaredMethods = doubleClass.getDeclaredMethods();
        List<String> staticMethodList = new ArrayList<>();

        for (Method method : declaredMethods) {
            if (Modifier.isStatic(method.getModifiers())) {
                staticMethodList.add(method.getName());
            }
        }

        String[] publicStaticMethods = staticMethodList.toArray(new String[0]);
        Arrays.sort(publicStaticMethods);
        // --end-->

        final String[] expected = {
            "compare", "doubleToLongBits", "doubleToRawLongBits", "hashCode",
            "isFinite", "isInfinite", "isNaN", "longBitsToDouble", "max",
            "min", "parseDouble", "sum", "toHexString", "toString", "valueOf",
            "valueOf"
        };

        assertArrayEquals(expected, publicStaticMethods);
    }

    @SuppressWarnings({"unused", "ConstantConditions", "RedundantThrows"})
    @Test
    void should_be_able_to_evaluate_object_field_values_at_runtime() throws Exception {
        Object employee = new Employee();

        // TODO: please get the value of `getTitle` method using reflection. No casting to Employee is allowed.
        // <--start
        Object result = employee.getClass().getDeclaredMethod("getTitle").invoke(employee);
        // --end-->

        assertEquals("Employee", result);
    }

    @SuppressWarnings({"unused", "ConstantConditions"})
    @Test
    void should_be_able_to_get_the_item_class_of_the_array() {
        Object employees = new Employee[0];

//        https://blog.csdn.net/pingnanlee/article/details/50387990
        // TODO: please get the class of array item `employees`
        // <--start
        Class<?> itemClass = employees.getClass().getComponentType();
        // --end-->

        assertEquals(Employee.class, itemClass);
    }

    @SuppressWarnings({"ConstantConditions", "unused"})
    @Test
    void should_be_able_to_get_the_methods_who_contains_MyAnnotation_annotation() {
        Class<MethodWithAnnotation> theClass = MethodWithAnnotation.class;

        // TODO: please get the methods who contains MyAnnotation annotation.
        // <--start

        ArrayList<String> strings = new ArrayList<>();
        Method[] declaredMethods = theClass.getDeclaredMethods();

        for (Method method : declaredMethods) {
            if(method.getAnnotation(MyAnnotation.class) != null) {
                strings.add(method.getName());
            }
        }
        String[] methodsContainsAnnotations = strings.toArray(new String[0]);
        // --end-->

        assertArrayEquals(new String[] {"theMethod"}, methodsContainsAnnotations);
    }

    @Test
    void get_private_method() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        assertEquals("MyClass Name", invokeMethod("getName"));
//        assertEquals(30, invokeMethod("getAge"));
        assertEquals("MyName", invokeMethod("getName", "MyName"));
    }

    private Object invokeMethod(String methodName, Object... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<MyClass> myClassClass = MyClass.class;
        Method declaredMethod = myClassClass.getDeclaredMethod(methodName, String.class);
        MyClass obj = new MyClass();
        Object invoke = declaredMethod.invoke(obj, args);
        return invoke;
    }

}

class MyClass{

//    public String getName(){
//        return "MyClass Name";
//    }

    public int getAge(){
        return 30;
    }

    public String getName(String name){
        return name;
    }
}

/*
 * - What is the class name of array type?
 * - How to compare 2 classes?
 * - What if the class does not contain a default constructor when you call `newInstance()`?
 * - What is source only annotation? Can we get source only annotations via reflection?
 */

package com.cultivation.javaBasic.showYourIntelligence;

import com.cultivation.javaBasic.util.Person;
import com.cultivation.javaBasic.util.WithName;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class NameImpl implements WithName, Person {
    @Override
    public String getName() {
        // TODO: please modify the following code to pass the test
        // <--start
        return Person.super.getName();
        //https://blog.csdn.net/travellersy/article/details/74537170
        // --end-->
    }
}

package com.cultivation.javaBasic.showYourIntelligence;

public class StackFrameHelper {
    public static String getCurrentMethodName() {
        // TODO: please modify the following code to pass the test
        // <--start
        StackTraceElement stackTraceElement = (new Throwable()).getStackTrace()[1];
        return stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        // --end-->
    }
}

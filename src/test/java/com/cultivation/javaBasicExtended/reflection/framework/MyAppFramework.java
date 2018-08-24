package com.cultivation.javaBasicExtended.reflection.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("WeakerAccess")
public class MyAppFramework {

    private Map<String, Class> controllerMap = new HashMap<>();

    public void registerController(Class controllerClazz) {
        // TODO: Please implement the method
        // <--start
        if (controllerClazz == null || controllerMap.containsKey(controllerClazz.getName())) {
            throw new IllegalArgumentException();
        }

        controllerMap.put(controllerClazz.getName(), controllerClazz);
        // --end-->
    }

    public Response getResponse(String requestController, String requestMethod) {
        // TODO: Please implement the method
        // <--start
        Class<?> controller = getControllerClass(requestController);
        if (controller != null) {
            try {
                Method method = controller.getDeclaredMethod(requestMethod);
                Object result = method.invoke(controller.newInstance());
                return getResponse(result);
            } catch (NoSuchMethodException e) {
                return getResponseWhenNoSuchMethod(requestMethod, controller);
            } catch (IllegalAccessException e) {
                return new Response(403);
            } catch (InvocationTargetException e) {
                Throwable t = e.getTargetException();
                return new Response(t.getMessage(), 500);
            } catch (Exception e) {
                return new Response(500);
            }
        }

        return new Response(404);
        // --end-->
    }

    private Response getResponseWhenNoSuchMethod(String requestMethod, Class<?> controller) {
        Method[] methods = controller.getMethods();
        for (Method method :
                methods) {
            if (method.getName().equals(requestMethod)) {
                return new Response(503);
            }
        }

        return new Response(404);
    }

    private Response getResponse(Object result) {
        if (result instanceof Response){
            return (Response) result;
        }

        return new Response(503);
    }

    private Class<?> getControllerClass(String requestController) {
        if (controllerMap.containsKey(requestController)) {
            return controllerMap.get(requestController);
        }

        return null;
    }

    // TODO: You can add additional methods here if you want
    // <--start
    // --end-->
}
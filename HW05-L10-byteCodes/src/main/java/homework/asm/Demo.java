package homework.asm;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

public class Demo {
    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, URISyntaxException, ClassNotFoundException {
        TestLogging testLogging = new TestLoggingImpl();
        testLogging.calculation(6);
        testLogging.calculation(6, "кошка");

    }

//    private static void start() throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        var loader = new MyClassLoader();
//        Class<?> clazz = loader.defineClass("homework.proxy.simple.TestLoggingImpl");
//        Arrays.stream(clazz.getMethods())
//                .forEach(method -> {
//                    try {
//                        isMethodNeedsLogging(method) ? runMethodWithLogging(method, clazz) : runMethod(method, clazz))
//                    } catch (InvocationTargetException e) {
//                        e.printStackTrace();
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    } catch (NoSuchMethodException e) {
//                        e.printStackTrace();
//                    } catch (InstantiationException e) {
//                        e.printStackTrace();
//                    }
//                });
//    }
//
//    private static Object runMethod(Method method, Class<?> clazz) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
//        runMethodWithParams(method, clazz)
//    }
//
//    private static Object runMethodWithLogging(Method method, Class<?> clazz) {
//
//    }
//
//    private static void runMethodWithParams(Method method, Class clazz) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
//        Constructor<?> constructor = clazz.getConstructor();
//        Object object = constructor.newInstance();
//        Class<?>[] paramTypes = method.getParameterTypes();
//        if (paramTypes[0].equals(int.class) && paramTypes[1].equals(null)) {
//            method.invoke(object, 6);
//        }
//        if (paramTypes[0].equals(int.class) && paramTypes[1].equals(String.class)) {
//            method.invoke(object, 6, "кошка");
//        }
//
//    }
//
//    private static boolean isMethodNeedsLogging(Method method) {
//        boolean needsLogging = false;
//        Annotation[] annotations = method.getDeclaredAnnotations();
//        for (Annotation annotation : annotations) {
//            if (annotation.annotationType().equals(Log.class))
//                needsLogging = true;
//        }
//        return needsLogging;
//    }
}

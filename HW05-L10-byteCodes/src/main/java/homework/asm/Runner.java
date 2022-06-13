//package homework.proxy.simple;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//
//public class Runner {
//
//    public static void runWithLogging(Set<Method> methods) {
//        try{
//        Method[] methods = clazz.getMethods();
//        for (Method method : methods) {
//            if (isMethodNeedsLogging(method)) {
//                TestLogging testLogging = Ioc.createLogging();
//                Class[] paramTypes = method.getParameterTypes();
//                    method.invoke(testLogging, 6);
//                    method.invoke(testLogging, 6, "кошка");
//                testLogging.calculation(6);
//                testLogging.calculation(6, "кошка");
//            }
//        }
//        }catch(InvocationTargetException | IllegalAccessException e) {
//            throw new RuntimeException(e.getMessage());
//        }
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
//}

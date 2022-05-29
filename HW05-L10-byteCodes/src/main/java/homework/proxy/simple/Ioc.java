package homework.proxy.simple;

import homework.proxy.framework.Log;
import homework.proxy.framework.TestLogging;
import homework.proxy.framework.TestLoggingImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class Ioc {
    private Ioc() {
    }

    static homework.proxy.framework.TestLogging createTestLogging() {
        InvocationHandler handler = new DemoInvocationHandler(new TestLoggingImpl());
        return (homework.proxy.framework.TestLogging) Proxy.newProxyInstance(Ioc.class.getClassLoader(),
                new Class<?>[]{homework.proxy.framework.TestLogging.class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final homework.proxy.framework.TestLogging testLogging;

        DemoInvocationHandler(TestLogging testLogging) {
            this.testLogging = testLogging;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("executed method: " + method.getName() + ", param: " + Arrays.toString(args));
            return method.invoke(testLogging, args);
        }

        @Override
        public String toString() {
            return "DemoInvocationHandler{" +
                    "TestLoggingImpl=" + testLogging +
                    '}';
        }

        private static boolean isMethodNeedsLogging(Method method) {
            boolean needsLogging = false;
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(Log.class))
                    needsLogging = true;
            }
            return needsLogging;
        }
    }
}

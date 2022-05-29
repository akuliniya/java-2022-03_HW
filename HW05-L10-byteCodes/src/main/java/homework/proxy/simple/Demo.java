package homework.proxy.simple;

import homework.proxy.framework.TestLogging;

public class Demo {

    public static void main(String[] args) {
        TestLogging testLogging = Ioc.createTestLogging();
        testLogging.calculation(6);
        testLogging.calculation(6, "кошка");
    }
}

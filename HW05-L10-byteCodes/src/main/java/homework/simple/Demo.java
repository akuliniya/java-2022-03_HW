package homework.simple;

import homework.asm.TestLogging;

public class Demo {

    public static void main(String[] args) {
        TestLogging testLogging = Ioc.createTestLogging();
        testLogging.calculation(6);
        testLogging.calculation(6, "кошка");
    }
}

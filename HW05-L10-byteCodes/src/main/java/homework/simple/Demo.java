package homework.simple;

public class Demo {

    public static void main(String[] args) {
        TestLogging testLogging = Ioc.createTestLogging();
        testLogging.calculation(6);
        testLogging.calculation(6, "кошка");
        testLogging.calculation(6, "кошка", 8);
    }
}

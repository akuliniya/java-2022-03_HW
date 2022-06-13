package homework.simple;

public class TestLoggingImpl implements TestLogging {
    public void calculation() {
        System.out.println("calculation without params");
    }

    @Override
    public void calculation(int param) {
        System.out.println("method 'calculation' is running with param: " + param);
        System.out.println("---------------------");
    }

    @Override
    public void calculation(int param, String param2) {
        System.out.printf("method 'calculation' is running with params: %d, %s %n", param, param2);
        System.out.println("---------------------");
    }

    @Override
    public void calculation(int param1, String param2, int param3) {
        System.out.printf("method 'calculation' is running with params: %d, %s, %d %n", param1, param2, param3);
        System.out.println("---------------------");

    }
}

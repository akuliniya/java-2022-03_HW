package homework.simple;

public class TestLogging {

    @Log
    public void calculation(int param) {
        System.out.println("calculation is running with param: " + param);
    }

    @Log
    public void calculation(int param, String sParam) {
        System.out.printf("calculation is running with params: %d, %s %n", param, sParam);
    }
}

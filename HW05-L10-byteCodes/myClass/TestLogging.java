package homework.proxy.simple;

public class TestLogging {
    TestLogging(){
    }

    public void calculationProxied(int param) {
        System.out.println("calculation is running with param: " + param);
    }

    public void calculationProxied(int param, String sParam) {
        System.out.printf("calculation is running with params: %d, %s %n", param, sParam);
    }

    public void calculation(int param) {
        System.out.printf();
        this.calculation(param);
    }

    public void calculation(int param, String sParam) {
        System.out.printf();
        this.calculation(param, sParam);
    }
}

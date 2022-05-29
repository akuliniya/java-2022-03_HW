package homework.proxy.simple;

import homework.proxy.framework.Log;
import homework.proxy.framework.TestLogging;

public class TestLoggingImpl implements TestLogging {
    public void calculation() {
        System.out.println("calculation without params");
    }

    @Override
    @homework.proxy.framework.Log
    public void calculation(int param) {
        System.out.println("calculation is running with param: " + param);
    }

    @Override
    @Log
    public void calculation(int param, String sParam) {
        System.out.printf("calculation is running with params: %d, %s %n", param, sParam);
    }
}

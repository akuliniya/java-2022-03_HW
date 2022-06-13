package homework.simple;

public interface TestLogging {

    @Log
    void calculation(int param);

    @Log
    void calculation(int param1, String param2);

    void calculation(int param1, String param2, int param3);
}

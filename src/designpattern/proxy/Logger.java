package designpattern.proxy;

public class Logger {
    public void log(String userId) {
        System.out.printf("Update DB, %s query number increase 1.\n", userId);
    }
}

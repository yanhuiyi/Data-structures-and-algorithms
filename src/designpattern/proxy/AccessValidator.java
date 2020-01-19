package designpattern.proxy;

public class AccessValidator {
    public boolean validate(String userId) {
        System.out.printf("Validate %s in DB to check if it's valid or not?\n", userId);
        if(userId.equals("foo")) {
            System.out.printf("%s logs in success!\n", userId);
            return true;
        } else {
            System.out.printf("%s logs in failure!\n", userId);
            return false;
        }
    }
}

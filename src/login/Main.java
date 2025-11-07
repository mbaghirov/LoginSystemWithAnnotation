package login;

import login.model.User;
import login.service.LoginProcess;

public class Main {
    public static void main(String[] args) {
        User wrongUser = new User("Mansur", "mbaghirov", "123", 24);
        User correctUser = new User("Mansur", "mbaghriov@gmail.com", "mansur58", 24);

        System.out.println("---- Checking wrong user ----");
        LoginProcess.login(wrongUser);

        System.out.println("\n---- Checking correct user ----");
        LoginProcess.login(correctUser);
    }
}
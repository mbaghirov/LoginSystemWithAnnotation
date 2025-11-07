package login.service;

import login.model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoginProcess {
    public static void login(User user){
        if(Validator.validate(user)){
            try (FileWriter writer = new FileWriter("log.txt", true)){
                writer.write(LocalDateTime.now() + " - User [" + user.getUserName() + "] successfully logged in.\n");
                System.out.println("User " + user.getUserName() + " successfully logged in.");
            }
            catch (IOException e) {
                System.out.println(e.getCause());
            }
        }
        else {
            System.out.println("Validation failed. Login unsuccessful.");
        }
    }
}

package login.model;

import login.annotations.Email;
import login.annotations.MinLegth;
import login.annotations.NotNull;
import login.annotations.Range;

public class User {

    @NotNull
    @MinLegth(3)
    private String userName;

    @NotNull
    @MinLegth(6)
    private String password;

    @Email
    private String email;

    @Range(min = 18, max = 65)
    private Integer age;

    public String getUserName() {
        return userName;
    }

    public User(String userName, String email, String password, Integer age) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

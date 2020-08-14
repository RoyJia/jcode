package model;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class User{
    Integer id;
    String userName;
    String password;
    String emailAddress;
    private int type = 0;

    public User() {
    }

    public User(Integer id, String userName, String password, String emailAddress) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    public static void main(String[] args) {
        Map<Integer, User> userMap = new HashMap<Integer, User>(){{
            put(1, new User(1, "Roy", "test123", "roy.jia@outlook.com"));
            put(2, new User(2, "Toy", "test123", "roy.jia@outlook.com"));
            put(3, new User(3, "Jerry", "test123", "roy.jia@outlook.com"));
            put(4, new User(4, "Allen", "test123", "roy.jia@outlook.com"));
        }};

        Map<Integer, String> avatarMap = userMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getUserName()));
        System.out.println(avatarMap.toString());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
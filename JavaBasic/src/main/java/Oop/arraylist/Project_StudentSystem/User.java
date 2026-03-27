package Oop.arraylist.Project_StudentSystem;

public class User {
    private String Username;
    private String Password;
    private String IDcard;
    private String PhoneNumber;

    public User() {
    }

    public User(String username, String password, String IDcard, String phoneNumber) {
        Username = username;
        Password = password;
        this.IDcard = IDcard;
        PhoneNumber = phoneNumber;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}

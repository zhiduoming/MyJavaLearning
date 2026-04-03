package Oop.APIdemo.APIObject;

import java.util.StringJoiner;

public class User implements Cloneable{
    private String username;
    private int age;
    private String password;
    private String path;
    int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};


    public User() {
    }

    public User(String username, int age, String password, String path, int[] data) {
        this.username = username;
        this.age = age;
        this.password = password;
        this.path = path;
        this.data = data;
    }

    /**
     * 获取
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     *
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置
     *
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取
     *
     * @return data
     */
    public int[] getData() {
        return data;
    }

    /**
     * 设置
     *
     * @param data
     */
    public void setData(int[] data) {
        this.data = data;
    }

    public String toString() {
        return "User{username = " + username + ", age = " + age + ", password = " + password + ", path = " + path + ", data = " + arrtoString(data) + "}";
    }

    public String arrtoString(int[] data) {
        StringJoiner sj =new StringJoiner(", ","[","]");
        for (int datum : data) {
            sj.add(datum + "");
        }
        return sj.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        int[] newdata =new int[this.data.length];
        for (int i = 0; i < newdata.length; i++) {
            newdata[i] =this.data[i];
        }
        User u=(User) super.clone();
        u.data=newdata;
        return u;
    }
}

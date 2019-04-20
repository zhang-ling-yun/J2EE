package cn.edu.scut.springmvc.entity;

/**
 * @author: rain
 * @date: 2019-4-15 09:23
 * @description: springmvc
 */
public class User {
    private String userName;

    private String password;

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
}

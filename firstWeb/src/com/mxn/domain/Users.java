package com.mxn.domain;

/**
 * CREATE TABLE USERS(
 * uid INT AUTO_INCREMENT PRIMARY KEY,
 * username VARCHAR(20) DEFAULT NULL,
 * PASSWORD VARCHAR(20) DEFAULT NULL,
 * nickname VARCHAR(20) DEFAULT NULL,
 * email  VARCHAR(30) DEFAULT NULL,
 * state INT(11) DEFAULT NULL,
 * CODE VARCHAR(64) DEFAULT NULL
 * )
 *
 * @author Geenk-MXN
 * @create 2018-03-12 16:44
 */

public class Users {
    private Integer uid;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private Integer state;
    private String code;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", state=" + state +
                ", code='" + code + '\'' +
                '}';
    }
}

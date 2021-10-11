package com.inhatc.loginexample;

public class UserAccount {
    // 사용자 계정 정보 모델 클래스
    private String idToken; // Firebase Uid(고유 토큰 정보)
    private String emailId;
    private String password;
    private String name;
    private String age;

    public UserAccount() {}

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }
}

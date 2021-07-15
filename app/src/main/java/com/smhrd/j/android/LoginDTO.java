package com.smhrd.j.android;

import java.io.Serializable;

public class LoginDTO implements Serializable {

    private String id, pw, name, tel, email, add, birth, status;

    public LoginDTO(String id, String pw, String name, String tel, String email, String add, String birth, String status) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.add = add;
        this.birth = birth;
        this.status = status;
    }

    public LoginDTO(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

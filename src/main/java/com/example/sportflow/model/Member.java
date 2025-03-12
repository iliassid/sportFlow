package com.example.sportflow.model;

import java.util.Date;

public class Member extends User{
    private int id;
    private int date;
    private String sport;

    public Member(int id, String name, String prenom, String email, String password, String role, int id1, int date, String sport) {
        super(id, name, prenom, email, password, role);
        this.id = id1;
        this.date = date;
        this.sport = sport;
    }

    public Member(int id, String name, String prenom, String email, String password, String role) {
        super(id, name, prenom, email, password, role);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}

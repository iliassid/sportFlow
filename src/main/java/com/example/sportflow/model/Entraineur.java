package com.example.sportflow.model;

public class Entraineur extends User {
    private int id;
    private String speciqlite;

    public Entraineur(int id, String name, String prenom, String email, String password, String role, int id1, String speciqlite) {
        super(id, name, prenom, email, password, role);
        this.id = id1;
        this.speciqlite = speciqlite;
    }

    public Entraineur() {
        super();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getSpeciqlite() {
        return speciqlite;
    }

    public void setSpeciqlite(String speciqlite) {
        this.speciqlite = speciqlite;
    }
}

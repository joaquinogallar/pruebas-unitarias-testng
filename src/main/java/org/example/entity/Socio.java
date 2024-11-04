package org.example.entity;

public class Socio {
    private String email;

    public Socio(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "email='" + email + '\'' +
                '}';
    }
}

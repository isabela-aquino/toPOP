package com.example.topop.domain;

import java.util.List;
import java.util.Objects;

public class User {
    private Long id;
    private String login;
    private String email;
    private String name;
    private List<UserBook> listaBooks;

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public List<UserBook> getListaBooks() {
        return listaBooks;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListaBooks(List<UserBook> listaBooks) {
        this.listaBooks = listaBooks;
    }

    public User(Long id, String login, String email, String name) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId()) && getLogin().equals(user.getLogin()) && Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getEmail());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", listaBooks=" + listaBooks +
                '}';
    }
}

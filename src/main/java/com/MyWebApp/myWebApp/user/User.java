package com.MyWebApp.myWebApp.user;

import jakarta.persistence.*;

@Entity
@Table(name = "librarydb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45, name="book_issued")
    private String bookissued;

    @Column(nullable = false, name="date")
    private String date;

    @Column(nullable = false, unique = true, name="name")
    private String name;

    @Column(nullable = false, unique = true, length = 45, name="email")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookissued() {
        return bookissued;
    }

    public void setBookissued(String bookissued) {
        this.bookissued = bookissued;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", bookissued='" + bookissued + '\'' +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

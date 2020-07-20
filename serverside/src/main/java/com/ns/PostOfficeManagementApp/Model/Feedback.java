package com.ns.PostOfficeManagementApp.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="name")
    @NotBlank(message="Name can't be blank")
    private String name;

    @Column(name = "email",length=100)
    @NotBlank(message = "Email can't be blank")
    private String email;

    @Column(name="message")
    @NotBlank(message="Message's name can't be blank")
    private String message;

    public Feedback() {

    }

    public Feedback(@NotBlank(message = "Name can't be blank") String name, @NotBlank(message = "Email can't be blank") String email, @NotBlank(message = "Message's name can't be blank") String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}






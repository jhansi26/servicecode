package com.ns.PostOfficeManagementApp.Model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "emailAddress",length=100)
    @NotBlank(message = "Email can't be blank")
    @Email(message = "invalid format for email")
    private String emailAddress;

    @Column(name = "password")
    @NotBlank(message = "Password can't be blank")
    @Size(min = 8, max = 15,message = "Minimum of 8 and maximum of 15")
    private String password;
    private String role;
    public Login() {
    }

    public Login(@NotBlank(message = "Email can't be blank") @Email(message = "invalid format for email") String emailAddress, @NotBlank(message = "Password can't be blank") @Size(min = 8, max = 15, message = "Minimum of 8 and maximum of 15") String password, String role) {
        this.emailAddress = emailAddress;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

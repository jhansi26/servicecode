package com.ns.PostOfficeManagementApp.Model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="statusofpost")
@Proxy(lazy=false)
public class StatusOfPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="senderName")
    @NotBlank(message="Sender's name can't be blank")
    private String senderName;

    @Column(name = "emailAddress",length=100)
    @NotBlank(message = "Email can't be blank")
    private String emailAddress;

    @Column(name="status")
    @NotBlank(message="Status's name can't be blank")
    private String status;

    public StatusOfPost() {

    }

    public StatusOfPost(@NotBlank(message = "Sender's name can't be blank") String senderName, @NotBlank(message = "Email can't be blank") String emailAddress, @NotBlank(message = "Status's name can't be blank") String status) {
        this.senderName = senderName;
        this.emailAddress = emailAddress;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StatusOfPost{" +
                "id=" + id +
                ", senderName='" + senderName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

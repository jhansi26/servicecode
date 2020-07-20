package com.ns.PostOfficeManagementApp.Model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "usernameReg")
    @NotBlank(message = "User Name can't be blank")
    @Pattern(regexp ="[a-z A-Z]{5,20}",message = "Only Alphabets Allowed")
    private String usernameReg;

    @Column(name = "passwordReg")
    @NotBlank(message = "Password can't be blank")
    @Size(min = 8, max = 15,message = "Minimum of 8 and maximum of 15")
    private String passwordReg;

    @Column(name = "email",length=100,unique=true)
    @NotBlank(message = "Email can't be blank")
    @Email(message = "invalid format for email")
    private String email;

    @Column(name = "phoneNumber")
    @NotBlank(message = "Contact no can't be blank")
    @Pattern(regexp = "[0-9]{5,10}",message = "Only Numbers Allowed")
    private String phoneNumber;


    @Column(name = "addressReg")
    @NotBlank(message = "Address can't be blank")
    private String addressReg;

    @Column(name = "country")
    @NotBlank(message = "Country can't be blank")
    private String country;

    @Column(name = "state")
    @NotBlank(message = "State Name can't be blank")
    private String state;


    @Column(name = "city")
    @NotBlank(message = "city can't be blank")
    private String city;


    @Column(name = "pincode")
    @NotBlank(message = "Pincode can't be blank")
    @Pattern(regexp = "[0-9]{6,10}",message = "Only Numbers Allowed")
    private String pincode;






    public User() {
    }

    public User(@NotBlank(message = "User Name can't be blank") @Pattern(regexp = " [a-z A-Z ]{5,20}", message = "Only Alphabets Allowed") String usernameReg, @NotBlank(message = "Password can't be blank") @Size(min = 8, max = 15, message = "Minimum of 8 and maximum of 15") String passwordReg, @NotBlank(message = "Email can't be blank") @Email(message = "invalid format for email") String email, @NotBlank(message = "Contact no can't be blank") @Pattern(regexp = "[0-9]{5,10}", message = "Only Numbers Allowed") String phoneNumber, @NotBlank(message = "Address can't be blank") String addressReg, @NotBlank(message = "Country can't be blank") String country, @NotBlank(message = "State Name can't be blank") String state, @NotBlank(message = "city can't be blank") String city, @NotBlank(message = "Pincode can't be blank") @Pattern(regexp = "[0-9 ]{6,10}", message = "Only Numbers Allowed") String pincode) {
        this.usernameReg = usernameReg;
        this.passwordReg = passwordReg;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addressReg = addressReg;
        this.country = country;
        this.state = state;
        this.city = city;
        this.pincode = pincode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsernameReg() {
        return usernameReg;
    }

    public void setUsernameReg(String usernameReg) {
        this.usernameReg = usernameReg;
    }

    public String getPasswordReg() {
        return passwordReg;
    }

    public void setPasswordReg(String passwordReg) {
        this.passwordReg = passwordReg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressReg() {
        return addressReg;
    }

    public void setAddressReg(String addressReg) {
        this.addressReg = addressReg;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", usernameReg='" + usernameReg + '\'' +
                ", passwordReg='" + passwordReg + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", addressReg='" + addressReg + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}

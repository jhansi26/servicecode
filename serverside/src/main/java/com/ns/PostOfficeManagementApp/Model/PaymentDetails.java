package com.ns.PostOfficeManagementApp.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="payment")
public class PaymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="username")
    @NotBlank(message="username's name can't be blank")
    @Pattern(regexp ="[a-z A-Z]{5,20}",message = "Only Alphabets Allowed")
    private String username;

    @Column(name="cardNumber")
    @NotBlank(message="cardNumber's name can't be blank")
    @Pattern(regexp ="[0-9]{16}",message = "Only Number's Allowed")
    private String cardNumber;

//    @Column(name="CVV")
//   // @NotBlank(message="CVV name can't be blank")
//    //@Pattern(regexp ="[0-9]{3}",message = "Only Number's Allowed and lenth(3)")
//    private int CVV;

    @Column(name="CVV")
    private String cvv;

    @Column(name = "expMonth")
    @NotBlank(message = "expMonth can't be blank")
    private String expMonth;

    @Column(name = "expYear")
    @NotBlank(message = "expYear can't be blank")
    private String expYear;

    public PaymentDetails() {
    }

    public PaymentDetails(@NotBlank(message = "username's name can't be blank") @Pattern(regexp = "[a-z A-Z]{5,20}", message = "Only Alphabets Allowed") String username, @NotBlank(message = "cardNumber's name can't be blank") @Pattern(regexp = "[0-9]{16}", message = "Only Number's Allowed") String cardNumber, String CVV, @NotBlank(message = "expMonth can't be blank") String expMonth, @NotBlank(message = "expYear can't be blank") String expYear) {
        this.username = username;
        this.cardNumber = cardNumber;
        this.cvv = CVV;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }


//


    public String getCVV() {
        return cvv;
    }

    public void setCVV(String CVV) {
        this.cvv = CVV;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", CVV='" + cvv + '\'' +
                ", expMonth='" + expMonth + '\'' +
                ", expYear='" + expYear + '\'' +
                '}';
    }
}


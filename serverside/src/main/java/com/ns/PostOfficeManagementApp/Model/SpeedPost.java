package com.ns.PostOfficeManagementApp.Model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="speedpost")
@Proxy(lazy=false)
public class SpeedPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="senderName")
    @NotBlank(message="Sender's name can't be blank")
    @Pattern(regexp ="[a-z A-Z]{5,20}",message = "Only Alphabets Allowed")
    private String senderName;

    @Column(name="senderPhoneNumber")
    @NotBlank(message="Sender's phone number can't be blank")
    @Pattern(regexp = "[0-9]{5,10}",message = "Only Numbers Allowed")
    private String senderPhoneNumber;

    @Column(name = "sendersEmail",length=100)
    @NotBlank(message = "Email can't be blank")
    @Email(message = "invalid format for email")
    private String sendersEmail;

    @Column(name = "senderAddress")
    @NotBlank(message = "Sender's address can't be blank")
    private String senderAddress;

    @Column(name = "senderCountry")
    @NotBlank(message = "Sender's country can't be blank")
    private String senderCountry;

    @Column(name = "senderState")
    @NotBlank(message = "Sender's state can't be blank")
    private String senderState;

    @Column(name = "senderCity")
    @NotBlank(message = "Sender's city can't be blank")
    private String senderCity;

    @Column(name="senderPincode")
    @NotBlank(message="Sender's pincode can't be blank")
    @Pattern(regexp = "[0-9]{6,10}",message = "Only Numbers Allowed")
    private String senderPincode;

    @Column(name="sendersPostWeight")
    @NotBlank(message="Sender's post-weight can't be blank")
    @Pattern(regexp = "^[1-9][0-9]*",message = "Only Numbers Allowed")
    private String sendersPostWeight;

    @Column(name = "sendersMoneyPay")
    private String sendersMoneyPay;

    @Column(name="receiverName")
    @NotBlank(message="Receiver's name can't be blank")
    @Pattern(regexp ="[a-z A-Z]{5,20}",message = "Only Alphabets Allowed")
    private String receiverName;

    @Column(name="receiverPhoneNumber")
    @NotBlank(message="Receiver's phone number can't be blank")
    @Pattern(regexp = "[0-9]{5,10}",message = "Only Numbers Allowed")
    private String receiverPhoneNumber;

    @Column(name = "receiverAddress")
    @NotBlank(message = "Receiver's address can't be blank")
    private String receiverAddress;

    @Column(name = "receiverCountry")
    @NotBlank(message = "Receiver's country can't be blank")
    private String receiverCountry;

    @Column(name = "receiverState")
    @NotBlank(message = "Receiver'sstate can't be blank")
    private String receiverState;

    @Column(name = "receiverCity")
    @NotBlank(message = "Receiver's city can't be blank")
    private String receiverCity;

    @Column(name="receiverPincode")
    @NotBlank(message="Receiver's pincode can't be blank")
    @Pattern(regexp = "[0-9]{6,10}",message = "Only Numbers Allowed")
    private String receiverPincode;

    @Column(name="status")
    @NotBlank(message="status")
    private String status;


    public SpeedPost() {
    }

    public SpeedPost(String senderName, String senderPhoneNumber, String sendersEmail, String senderAddress, String senderCountry, String senderState, String senderCity, String senderPincode, String sendersPostWeight, String sendersMoneyPay, String receiverName, String receiverPhoneNumber, String receiverAddress, String receiverCountry, String receiverState, String receiverCity, String receiverPincode, String status) {
        this.senderName = senderName;
        this.senderPhoneNumber = senderPhoneNumber;
        this.sendersEmail = sendersEmail;
        this.senderAddress = senderAddress;
        this.senderCountry = senderCountry;
        this.senderState = senderState;
        this.senderCity = senderCity;
        this.senderPincode = senderPincode;
        this.sendersPostWeight = sendersPostWeight;
        this.sendersMoneyPay = sendersMoneyPay;
        this.receiverName = receiverName;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.receiverAddress = receiverAddress;
        this.receiverCountry = receiverCountry;
        this.receiverState = receiverState;
        this.receiverCity = receiverCity;
        this.receiverPincode = receiverPincode;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public String getSenderPhoneNumber() {
        return senderPhoneNumber;
    }

    public void setSenderPhoneNumber(String senderPhoneNumber) {
        this.senderPhoneNumber = senderPhoneNumber;
    }

    public String getSendersEmail() {
        return sendersEmail;
    }

    public void setSendersEmail(String sendersEmail) {
        this.sendersEmail = sendersEmail;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderCountry() {
        return senderCountry;
    }

    public void setSenderCountry(String senderCountry) {
        this.senderCountry = senderCountry;
    }

    public String getSenderState() {
        return senderState;
    }

    public void setSenderState(String senderState) {
        this.senderState = senderState;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getSenderPincode() {
        return senderPincode;
    }

    public void setSenderPincode(String senderPincode) {
        this.senderPincode = senderPincode;
    }

    public String getSendersPostWeight() {
        return sendersPostWeight;
    }

    public void setSendersPostWeight(String sendersPostWeight) {
        this.sendersPostWeight = sendersPostWeight;
    }

    public String getSendersMoneyPay() {
        return sendersMoneyPay;
    }

    public void setSendersMoneyPay(String sendersMoneyPay) {
        this.sendersMoneyPay = sendersMoneyPay;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverCountry() {
        return receiverCountry;
    }

    public void setReceiverCountry(String receiverCountry) {
        this.receiverCountry = receiverCountry;
    }

    public String getReceiverState() {
        return receiverState;
    }

    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverPincode() {
        return receiverPincode;
    }

    public void setReceiverPincode(String receiverPincode) {
        this.receiverPincode = receiverPincode;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "SpeedPost{" +
                "id=" + id +
                ", senderName='" + senderName + '\'' +
                ", senderPhoneNumber='" + senderPhoneNumber + '\'' +
                ", sendersEmail='" + sendersEmail + '\'' +
                ", senderAddress='" + senderAddress + '\'' +
                ", senderCountry='" + senderCountry + '\'' +
                ", senderState='" + senderState + '\'' +
                ", senderCity='" + senderCity + '\'' +
                ", senderPincode='" + senderPincode + '\'' +
                ", sendersPostWeight='" + sendersPostWeight + '\'' +
                ", sendersMoneyPay='" + sendersMoneyPay + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverPhoneNumber='" + receiverPhoneNumber + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", receiverCountry='" + receiverCountry + '\'' +
                ", receiverState='" + receiverState + '\'' +
                ", receiverCity='" + receiverCity + '\'' +
                ", receiverPincode='" + receiverPincode + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}


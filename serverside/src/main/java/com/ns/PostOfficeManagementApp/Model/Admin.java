package com.ns.PostOfficeManagementApp.Model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "empId")
    @NotBlank(message = "Employee Id  can't be blank")
    private String empId;

    @Column(name = "adminnameReg")
    @NotBlank(message = "User Name can't be blank")
    @Pattern(regexp ="[a-z A-Z]{5,20}",message = "Only Alphabets Allowed")
    private String adminnameReg;

    @Column(name = "adminDesignation")
    @NotBlank(message = "Designation can't be blank")
    private String adminDesignation;

    @Column(name = "adminpasswordReg")
    @NotBlank(message = "Password can't be blank")
    @Size(min = 8, max = 15,message = "Minimum of 8 and maximum of 15")
    private String adminpasswordReg;


    @Column(name = "adminemail",length=100,unique=true)
    @NotBlank(message = "Email can't be blank")
    @Email(message = "invalid format for email")
    private String adminemail;

    @Column(name = "adminphoneNumber")
    @NotBlank(message = "Contact no can't be blank")
    @Pattern(regexp = "[0-9]{5,10}",message = "Only Numbers Allowed")
    private String adminphoneNumber;

    @Column(name = "adminaddressReg")
    @NotBlank(message = "Address can't be blank")
    private String adminaddressReg;

    @Column(name = "admincountry")
    @NotBlank(message = "Country can't be blank")
    private String admincountry;

    @Column(name = "adminstate")
    @NotBlank(message = "State can't be blank")
    private String adminstate;

    @Column(name = "admincity")
    @NotBlank(message = "City Name can't be blank")
    private String admincity;

    @Column(name = "adminpincode")
    @NotNull(message = "Pincode can't be blank")
    @Pattern(regexp = "[0-9]{6,10}",message = "Only Numbers Allowed")
    private String adminpincode;






    public Admin() {
    }

    public Admin(@NotBlank(message = "User Name can't be blank") @Pattern(regexp = " [a-z A-Z()]{5,20}", message = "Only Alphabets Allowed") String adminnameReg, @NotBlank(message = "Designation can't be blank") String adminDesignation, @NotBlank(message = "Password can't be blank") @Size(min = 8, max = 15, message = "Minimum of 8 and maximum of 15") String adminpasswordReg, @NotBlank(message = "Email can't be blank") @Email(message = "invalid format for email") String adminemail, @NotNull(message = "Contact no can't be blank") @Pattern(regexp = "[0-9()]{5,10}", message = "Only Numbers Allowed") String adminphoneNumber, @NotBlank(message = "Address can't be blank") String adminaddressReg, @NotBlank(message = "Country can't be blank") String admincountry, @NotBlank(message = "State can't be blank") String adminstate, @NotBlank(message = "City Name can't be blank") String admincity, @NotNull(message = "Pincode can't be blank") @Pattern(regexp = "[0-9() ]{6,10}", message = "Only Numbers Allowed") String adminpincode) {

        this.adminnameReg = adminnameReg;
        this.adminDesignation = adminDesignation;
        this.adminpasswordReg = adminpasswordReg;
        this.adminemail = adminemail;
        this.adminphoneNumber = adminphoneNumber;
        this.adminaddressReg = adminaddressReg;
        this.admincountry = admincountry;
        this.adminstate = adminstate;
        this.admincity = admincity;
        this.adminpincode = adminpincode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getAdminnameReg() {
        return adminnameReg;
    }

    public void setAdminnameReg(String adminnameReg) {
        this.adminnameReg = adminnameReg;
    }

    public String getAdminDesignation() {
        return adminDesignation;
    }

    public void setAdminDesignation(String adminDesignation) {
        this.adminDesignation = adminDesignation;
    }

    public String getAdminpasswordReg() {
        return adminpasswordReg;
    }

    public void setAdminpasswordReg(String adminpasswordReg) {
        this.adminpasswordReg = adminpasswordReg;
    }

    public String getAdminemail() {
        return adminemail;
    }

    public void setAdminemail(String adminemail) {
        this.adminemail = adminemail;
    }

    public String getAdminphoneNumber() {
        return adminphoneNumber;
    }

    public void setAdminphoneNumber(String adminphoneNumber) {
        this.adminphoneNumber = adminphoneNumber;
    }

    public String getAdminaddressReg() {
        return adminaddressReg;
    }

    public void setAdminaddressReg(String adminaddressReg) {
        this.adminaddressReg = adminaddressReg;
    }

    public String getAdmincountry() {
        return admincountry;
    }

    public void setAdmincountry(String admincountry) {
        this.admincountry = admincountry;
    }

    public String getAdminstate() {
        return adminstate;
    }

    public void setAdminstate(String adminstate) {
        this.adminstate = adminstate;
    }

    public String getAdmincity() {
        return admincity;
    }

    public void setAdmincity(String admincity) {
        this.admincity = admincity;
    }

    public String getAdminpincode() {
        return adminpincode;
    }

    public void setAdminpincode(String adminpincode) {
        this.adminpincode = adminpincode;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", adminnameReg='" + adminnameReg + '\'' +
                ", adminDesignation='" + adminDesignation + '\'' +
                ", adminpasswordReg='" + adminpasswordReg + '\'' +
                ", adminemail='" + adminemail + '\'' +
                ", adminphoneNumber='" + adminphoneNumber + '\'' +
                ", adminaddressReg='" + adminaddressReg + '\'' +
                ", admincountry='" + admincountry + '\'' +
                ", adminstate='" + adminstate + '\'' +
                ", admincity='" + admincity + '\'' +
                ", adminpincode='" + adminpincode + '\'' +
                '}';
    }
}

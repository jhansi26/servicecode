package com.ns.PostOfficeManagementApp.Controller;

import com.ns.PostOfficeManagementApp.Model.Login;
import com.ns.PostOfficeManagementApp.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    LoginRepository loginRepository;



    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Login> saveLogin(@RequestBody @Valid Login login) throws Exception {

        Login newLogin = loginRepository.save(login);
        System.out.println("**************************");
        System.out.println(newLogin);
        HttpStatus status=HttpStatus.CREATED;
        ResponseEntity<Login> responseEntity = new ResponseEntity<Login>(newLogin,status);
        System.out.println(responseEntity);
        return responseEntity;

    }

    @RequestMapping(value = "/signin/{emailAddress}/{role}", method = RequestMethod.GET,produces = "application/json")
    public Login getone(@PathVariable String emailAddress,@PathVariable String role) throws Exception {
        System.out.println(emailAddress+"is displayeddd");
        System.out.println(role+"is displayeddd");
        Login responseEntity= loginRepository.findByEmailAddressAndRole(emailAddress,role);
        System.out.println(responseEntity);
        return responseEntity;
    }


}

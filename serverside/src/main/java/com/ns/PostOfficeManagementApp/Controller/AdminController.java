package com.ns.PostOfficeManagementApp.Controller;

import com.ns.PostOfficeManagementApp.Model.Admin;
import com.ns.PostOfficeManagementApp.Model.Feedback;
import com.ns.PostOfficeManagementApp.Model.StatusOfPost;
import com.ns.PostOfficeManagementApp.Repository.AdminRepository;
import com.ns.PostOfficeManagementApp.Repository.FeedbackRepository;
import com.ns.PostOfficeManagementApp.Repository.LoginRepository;
import com.ns.PostOfficeManagementApp.Repository.StatusOfPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admins")
public class AdminController {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    StatusOfPostRepository statusOfPostRepository;
    @Autowired
    FeedbackRepository feedbackRepository;


    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Admin> newUser(@RequestBody @Valid Admin admin) throws Exception {


        Admin newadmin = adminRepository.save(admin);

        System.out.println(newadmin);
        ResponseEntity<Admin> responseEntity = new ResponseEntity<Admin>(newadmin, HttpStatus.CREATED);
        System.out.println(responseEntity);
        return responseEntity;
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Admin>> getList() throws Exception {
        List<Admin> adminsList = adminRepository.findAll();
        return new ResponseEntity<>(adminsList, HttpStatus.OK);
    }

    @RequestMapping(value = "/listcount", method = RequestMethod.GET, produces = "application/json")
    public long getCount() throws Exception {
        long responseEntity = adminRepository.count();
        return responseEntity;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) throws Exception {
        adminRepository.deleteById(id);
        return "true";
    }

    @RequestMapping(value = "/getone/{adminemail}", method = RequestMethod.GET,produces = "application/json")
    public Admin getone(@PathVariable String adminemail) throws Exception {
        System.out.println(adminemail+"is displaying");
        Admin responseEntity= adminRepository.findByAdminemail(adminemail);
        System.out.println(responseEntity);
        return responseEntity;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Admin> UpdateJournal(@RequestBody Admin user) throws Exception {

        Admin updatedAdmin =  adminRepository.save(user);

        ResponseEntity<Admin> responseEntity = new ResponseEntity<Admin>(updatedAdmin,  HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value="/statusOfPostList",method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<StatusOfPost>> statusPostList() throws Exception
    {
        List<StatusOfPost> list=statusOfPostRepository.findAll();
        return new ResponseEntity<>(list,HttpStatus.OK);


    }
//    @RequestMapping(method=RequestMethod.GET, value="/rowDetails/{id}",produces="application/json" )
//    public StatusOfPost  getUpdateId(@PathVariable Long id)
//    {
//        StatusOfPost responseEntity=statusOfPostRepository.getOne(id);
//
//        return responseEntity;
//



    @RequestMapping(value = "/updateStatusOfPost/{id}", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void UpdatePostStatus( @PathVariable Long id) throws Exception {
        System.out.println("poststatus  "+id);
        System.out.println("Patchworking");
       //Long id = statusOfPost.getId();
        statusOfPostRepository.findByCustomQuery(id);
    }


    //FEEDBACK LIST
    @RequestMapping(value = "/feedback", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Feedback>> getFeedbackList() throws Exception {
        List<Feedback> feedbackList = feedbackRepository.findAll();
        return new ResponseEntity<>(feedbackList, HttpStatus.OK);
    }




}

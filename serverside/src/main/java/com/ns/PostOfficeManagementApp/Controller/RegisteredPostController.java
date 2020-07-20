package com.ns.PostOfficeManagementApp.Controller;

import com.ns.PostOfficeManagementApp.Model.RegisteredPost;
import com.ns.PostOfficeManagementApp.Model.SpeedPost;
import com.ns.PostOfficeManagementApp.Repository.RegisteredPostRepository;
import com.ns.PostOfficeManagementApp.Repository.SpeedPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/registeredpost")
public class RegisteredPostController {
    @Autowired
    RegisteredPostRepository registeredPostRepository;
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RegisteredPost> newUser(@RequestBody @Valid RegisteredPost registeredPost)throws Exception {
        System.out.println("Speed Post  values"+registeredPost);

        RegisteredPost newPost = registeredPostRepository.save(registeredPost);

        System.out.println("newPost" +newPost);
        ResponseEntity<RegisteredPost> responseEntity = new ResponseEntity<>(newPost, HttpStatus.CREATED);
        System.out.println(responseEntity);
        return responseEntity;
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<RegisteredPost>> getList() throws Exception {
        List<RegisteredPost> usersList = registeredPostRepository.findAll();
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

    @RequestMapping(value = "/listcount", method = RequestMethod.GET, produces = "application/json")
    public long getCount() throws Exception {
        long responseEntity = registeredPostRepository.count();
        return responseEntity;
    }

    @RequestMapping(method=RequestMethod.GET, value="/rowDetails/{id}",produces="application/json" )
    public RegisteredPost  getUpdateId(@PathVariable Long id) throws Exception
    {
        RegisteredPost responseEntity=registeredPostRepository.getOne(id);

        return responseEntity;

    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) throws Exception {
        registeredPostRepository.deleteById(id);
        return "true";
    }


    @RequestMapping(value = "/updatestatusRejected/{id}", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity UpdateJournagggl(@PathVariable Long id) throws Exception {

        registeredPostRepository.findByCustomQueryRejected(id);

        ResponseEntity responseEntity = new ResponseEntity(  HttpStatus.ACCEPTED);
        return responseEntity;
    }

    @RequestMapping(value = "/updatestatusAccepted/{id}", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity UpdateJournal(@PathVariable Long id) throws Exception {

        registeredPostRepository.findByCustomQueryAccepted(id);

        ResponseEntity<SpeedPost> responseEntity = new ResponseEntity(HttpStatus.ACCEPTED);
        return responseEntity;
    }

//    @RequestMapping(method=RequestMethod.PUT, consumes="application/json" ,value="/update")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<SpeedPost> saveJournalUpdate(@RequestBody SpeedPost speedPost, UriComponentsBuilder ucb) {
//        System.out.println(speedPost);
//
//        SpeedPost saved = speedPostRepository.save(speedPost);
//
////        HttpHeaders headers = new HttpHeaders();
////        URI locationUri = ucb.path("page/details")
////                .path(String.valueOf(saved.getId()))
////                .build()
////                .toUri();
////        headers.setLocation(locationUri);
//
//        ResponseEntity<SpeedPost> responseEntity = new ResponseEntity<SpeedPost>(saved, HttpStatus.CREATED);
//        return responseEntity;
//    }
}

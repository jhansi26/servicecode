package com.ns.PostOfficeManagementApp.Controller;

import com.ns.PostOfficeManagementApp.Model.SpeedPost;
import com.ns.PostOfficeManagementApp.Repository.SpeedPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/speedpost")
public class SpeedPostController {
    @Autowired
    SpeedPostRepository speedPostRepository;
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SpeedPost> newUser(@RequestBody @Valid SpeedPost speedPost) throws Exception {
        System.out.println("Speed Post  values"+speedPost);

        SpeedPost newPost = speedPostRepository.save(speedPost);

        System.out.println("newPost" +newPost);
        ResponseEntity<SpeedPost> responseEntity = new ResponseEntity<SpeedPost>(newPost, HttpStatus.CREATED);
        System.out.println(responseEntity);
        return responseEntity;
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<SpeedPost>> getList() throws Exception  {
        List<SpeedPost> usersList = speedPostRepository.findAll();
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

    @RequestMapping(value = "/listcount", method = RequestMethod.GET, produces = "application/json")
    public long getCount() throws Exception  {
        long responseEntity = speedPostRepository.count();
        return responseEntity;
    }

    @RequestMapping(method=RequestMethod.GET, value="/rowDetails/{id}",produces="application/json" )
    public SpeedPost  getUpdateId(@PathVariable Long id) throws Exception
    {
        SpeedPost responseEntity=speedPostRepository.getOne(id);

        return responseEntity;

    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) {
        speedPostRepository.deleteById(id);
        return "true";
    }

//    @RequestMapping(value = "/getone/{id}", method = RequestMethod.GET,produces = "application/json")
//    public SpeedPost getone(@PathVariable String sendersEmail) {
//        System.out.println(sendersEmail+"is displaying....");
//        SpeedPost responseEntity= speedPostRepository.findBySendersEmail(sendersEmail);
//        System.out.println(responseEntity);
//        return responseEntity;
//    }


    @RequestMapping(value = "/updatestatusRejected/{id}", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity UpdateJournagggl(@PathVariable Long id) throws Exception  {

         speedPostRepository.findByCustomQueryRejected(id);

        ResponseEntity responseEntity = new ResponseEntity(  HttpStatus.ACCEPTED);
        return responseEntity;
    }

    @RequestMapping(value = "/updatestatusAccepted/{id}", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity UpdateJournal(@PathVariable Long id) throws Exception  {

          speedPostRepository.findByCustomQueryAccepted(id);

        ResponseEntity responseEntity = new ResponseEntity(  HttpStatus.ACCEPTED);
        return responseEntity;
    }


//    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<SpeedPost> UpdateJournal(@RequestBody SpeedPost user) {
//
//        SpeedPost updatedPostValue =  speedPostRepository.save(user);
//
//        ResponseEntity<SpeedPost> responseEntity = new ResponseEntity<SpeedPost>(updatedPostValue,  HttpStatus.CREATED);
//        return responseEntity;
//    }

    @RequestMapping(method=RequestMethod.PUT, consumes="application/json" ,value="/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SpeedPost> saveJournalUpdate(@RequestBody SpeedPost speedPost, UriComponentsBuilder ucb) throws Exception  {
        System.out.println(speedPost);

        SpeedPost saved = speedPostRepository.save(speedPost);

//        HttpHeaders headers = new HttpHeaders();
//        URI locationUri = ucb.path("page/details")
//                .path(String.valueOf(saved.getId()))
//                .build()
//                .toUri();
//        headers.setLocation(locationUri);

        ResponseEntity<SpeedPost> responseEntity = new ResponseEntity<SpeedPost>(saved, HttpStatus.CREATED);
        return responseEntity;
    }

}

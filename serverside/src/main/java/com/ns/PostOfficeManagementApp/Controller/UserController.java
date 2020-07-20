package com.ns.PostOfficeManagementApp.Controller;

import com.ns.PostOfficeManagementApp.Model.Feedback;
import com.ns.PostOfficeManagementApp.Model.PaymentDetails;
import com.ns.PostOfficeManagementApp.Model.StatusOfPost;
import com.ns.PostOfficeManagementApp.Model.User;
import com.ns.PostOfficeManagementApp.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    StatusOfPostRepository statusOfPostRepository;

    @Autowired
    PaymentDetailsRepository paymentDetailsRepository;

    @Autowired
    FeedbackRepository feedbackRepository;

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> newUser(@RequestBody @Valid User user) throws Exception {

        System.out.println("User value"+user);
    try {
        User newuser = userRepository.save(user);

        System.out.println(newuser);
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(newuser, HttpStatus.CREATED);
        System.out.println(responseEntity);
        return responseEntity;
    }
    catch (Exception e) {
        if (e.getMessage().contains("ConstraintViolationException")) {
            ResponseEntity<Object> responseEntity = new ResponseEntity<>("Email Id Already Exist", HttpStatus.CONFLICT);
            return responseEntity;
        }
        return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }



    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<User>> getList() throws Exception  {
        List<User> usersList = userRepository.findAll();
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

    @RequestMapping(value = "/listcount", method = RequestMethod.GET, produces = "application/json")
    public long getCount() throws Exception {
        long responseEntity = userRepository.count();
        return responseEntity;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) throws Exception {
        userRepository.deleteById(id);
        return "true";
    }

    @RequestMapping(value = "/getone/{email}", method = RequestMethod.GET,produces = "application/json")
    public User getone(@PathVariable String email) throws Exception {
        System.out.println(email+"is displaying....");
        User responseEntity= userRepository.findByEmail(email);
        System.out.println(responseEntity);
        return responseEntity;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> UpdateJournal(@RequestBody User user) throws Exception {

        User updatedUser =  userRepository.save(user);

        ResponseEntity<User> responseEntity = new ResponseEntity<User>(updatedUser,  HttpStatus.CREATED);
        return responseEntity;
    }
///**** POST (STATUS) STARTS*****/
    @RequestMapping(value = "/statusOfPost", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StatusOfPost> newPostStatus(@RequestBody @Valid StatusOfPost statusOfPost) throws Exception {
        System.out.println("StatusOfPost value"+statusOfPost);

        StatusOfPost newPostStatusVar = statusOfPostRepository.save(statusOfPost);

        System.out.println(newPostStatusVar);
        ResponseEntity<StatusOfPost> responseEntity = new ResponseEntity<StatusOfPost>(statusOfPost, HttpStatus.CREATED);
        System.out.println(responseEntity);
        return responseEntity;
    }


////**** END****///
    @RequestMapping(value = "/paymentDetails", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PaymentDetails> newPayment(@RequestBody PaymentDetails paymentDetails) throws Exception {
        System.out.println("PaymentDetails value"+paymentDetails);

        PaymentDetails newPaymentVar = paymentDetailsRepository.save(paymentDetails);

        System.out.println(newPaymentVar);
        ResponseEntity<PaymentDetails> responseEntity = new ResponseEntity<PaymentDetails>(paymentDetails, HttpStatus.CREATED);
        System.out.println(responseEntity);
        return responseEntity;
    }

    //FEEDBACK POST()
    @RequestMapping(value = "/feedback", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Feedback> newPayment(@RequestBody Feedback feedback) throws Exception {
        System.out.println("PaymentDetails value"+feedback);

        Feedback newPaymentVar = feedbackRepository.save(feedback);

        System.out.println(newPaymentVar);
        ResponseEntity<Feedback> responseEntity = new ResponseEntity<Feedback>(feedback, HttpStatus.CREATED);
        System.out.println(responseEntity);
        return responseEntity;
    }
}

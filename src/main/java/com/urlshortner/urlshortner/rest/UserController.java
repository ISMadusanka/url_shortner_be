package com.urlshortner.urlshortner.rest;

import com.urlshortner.urlshortner.dao.VerificationRepository;
import com.urlshortner.urlshortner.entity.User;
import com.urlshortner.urlshortner.entity.Verification;
import com.urlshortner.urlshortner.event.RegistrationCompleteEvent;
import com.urlshortner.urlshortner.rest.request.RegistrationRequest;
import com.urlshortner.urlshortner.service.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private ApplicationEventPublisher publisher;
    private VerificationRepository verificationRepository;

    @Autowired
    public UserController(UserService userService, ApplicationEventPublisher publisher, VerificationRepository verificationRepository){
        this.userService=userService;
        this.publisher=publisher;
        this.verificationRepository=verificationRepository;
    };

    @PostMapping("/register")
    public String registerUser(@RequestBody RegistrationRequest request, HttpServletRequest servletRequest){

        User user = userService.registerUser(request);

        publisher.publishEvent(new RegistrationCompleteEvent(user,appUrl(servletRequest)));

        return "success, check email";

    }

    @GetMapping("/verify")
    public String verifyToken(@RequestParam("token") String token){
        Verification verification = verificationRepository.findByToken(token);

        if (verification.getUser().isEnabled()){
            return "Account is already verified. Please log in!";
        }

        String verificationResult = userService.verifyToken(token);

        if (verificationResult.equalsIgnoreCase("valid")){
            return "Verification success";
        }
        return "Invalid";
    }



    public String appUrl(HttpServletRequest request){
        return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    }
}

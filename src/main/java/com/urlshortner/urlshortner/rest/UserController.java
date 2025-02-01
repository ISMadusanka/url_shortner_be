package com.urlshortner.urlshortner.rest;

import com.urlshortner.urlshortner.dao.VerificationRepository;
import com.urlshortner.urlshortner.entity.User;
import com.urlshortner.urlshortner.entity.Verification;
import com.urlshortner.urlshortner.event.RegistrationCompleteEvent;
import com.urlshortner.urlshortner.rest.request.RegistrationRequest;
import com.urlshortner.urlshortner.service.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
        System.out.println("vv:"+verification.toString());
        if (verification.getUser().isEnabled()){
            return "Account is already verified. Please log in!";
        }

        String verificationResult = userService.verifyToken(token);

        if (verificationResult.equalsIgnoreCase("valid")){
            return "Verification success";
        }
        return "Invalid";
    }

    @GetMapping("/session")
    @ResponseBody
    public ResponseEntity<Map<String, String>> getSessionID(HttpSession session) {
        Map<String, String> response = new HashMap<>();
        response.put("session", session.getId());
        return ResponseEntity.ok(response);
    }




    public String appUrl(HttpServletRequest request){
        return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    }
}

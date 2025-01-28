package com.urlshortner.urlshortner.rest;

import com.urlshortner.urlshortner.entity.User;
import com.urlshortner.urlshortner.event.RegistrationCompleteEvent;
import com.urlshortner.urlshortner.rest.request.RegistrationRequest;
import com.urlshortner.urlshortner.service.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private ApplicationEventPublisher publisher;

    @Autowired
    public UserController(UserService userService, ApplicationEventPublisher publisher){
        this.userService=userService;
        this.publisher=publisher;
    };

    @PostMapping("/register")
    public String registerUser(@RequestBody RegistrationRequest request, HttpServletRequest servletRequest){

        User user = userService.registerUser(request);

        publisher.publishEvent(new RegistrationCompleteEvent(user,appUrl(servletRequest)));

        return "success, check email";

    }



    public String appUrl(HttpServletRequest request){
        return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    }
}

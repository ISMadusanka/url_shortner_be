package com.urlshortner.urlshortner.event.listener;

import com.urlshortner.urlshortner.entity.User;
import com.urlshortner.urlshortner.event.RegistrationCompleteEvent;
import com.urlshortner.urlshortner.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    private UserService userService;

    @Autowired
    public RegistrationCompleteEventListener(UserService userService){
        this.userService=userService;
    }

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //get user
        User user = event.getUser();

        //generate token
        String verificationToken = UUID.randomUUID().toString();

        //store token
        userService.saveVerificationToken(user,verificationToken);
        //generate verify url
        String url = event.getAppUrl()+"/user/verify?token="+verificationToken;

        //send url
        System.out.println(url);


    }
}

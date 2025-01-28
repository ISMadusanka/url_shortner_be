package com.urlshortner.urlshortner.event;

import com.urlshortner.urlshortner.entity.User;
import org.springframework.context.ApplicationEvent;

public class RegistrationCompleteEvent extends ApplicationEvent {

    private User user;
    private String appUrl;


    public RegistrationCompleteEvent(User user, String appUrl) {
        super(user);
        this.user=user;
        this.appUrl=appUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }
}

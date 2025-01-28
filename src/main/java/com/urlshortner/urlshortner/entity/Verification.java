package com.urlshortner.urlshortner.entity;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "verification")
public class Verification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token")
    private String token;

    @Column(name = "expire")
    private Date expire;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Verification(String token, User user) {
        super();
        this.token = token;
        this.user = user;
        this.expire = this.getExpireTime();
    }

    public Verification(String token) {
        super();
        this.token = token;
        this.expire = this.getExpireTime();
    }

    private Date getExpireTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE,10);

        return new Date(calendar.getTime().getTime());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

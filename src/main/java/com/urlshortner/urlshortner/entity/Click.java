package com.urlshortner.urlshortner.entity;

import com.urlshortner.urlshortner.entity.enums.DeviceType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "click")
public class Click {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "path",nullable = false)
    private URL url;

    @Column(nullable = false, name = "device_type")
    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;

    @Column(length = 100, name = "country")
    private String country;

    @Column(nullable = false, name = "click_time")
    private LocalDateTime clickTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getClickTime() {
        return clickTime;
    }

    public void setClickTime(LocalDateTime clickTime) {
        this.clickTime = clickTime;
    }
}

package com.urlshortner.urlshortner.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "urldeviceclick")
public class URLDeviceClick {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "path",nullable = false)
    private URL url;

    @Column(nullable = false, name = "total_clicks")
    private int totalClicks;

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

    public int getTotalClicks() {
        return totalClicks;
    }

    public void setTotalClicks(int totalClicks) {
        this.totalClicks = totalClicks;
    }
}

package com.urlshortner.urlshortner.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "urldailyclick")
@IdClass(URLDailyClickId.class) // Specify composite key class
public class URLDailyClick {

    @Id
    @ManyToOne
    @JoinColumn(name = "path", nullable = false)
    private URL url;

    @Id
    private LocalDate date;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private int totalClicks;

    // Getters and Setters
    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTotalClicks() {
        return totalClicks;
    }

    public void setTotalClicks(int totalClicks) {
        this.totalClicks = totalClicks;
    }
}

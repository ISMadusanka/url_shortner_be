package com.urlshortner.urlshortner.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class URLDailyClickId implements Serializable {
    private String url;
    private LocalDate date;

    // Default constructor
    public URLDailyClickId() {}

    // Constructor
    public URLDailyClickId(String url, LocalDate date) {
        this.url = url;
        this.date = date;
    }

    // Getters and Setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        URLDailyClickId that = (URLDailyClickId) o;
        return Objects.equals(url, that.url) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, date);
    }
}

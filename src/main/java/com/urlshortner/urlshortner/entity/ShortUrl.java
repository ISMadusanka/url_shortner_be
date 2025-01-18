package com.urlshortner.urlshortner.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "short_url")
public class ShortUrl {
    @Id
    @Column(name = "path")
    private String path;

    @Column(name = "link")
    private String link;

    public ShortUrl() {
    }

    public ShortUrl(String path, String link) {
        this.path = path;
        this.link = link;
    }

    public String getId() {
        return path;
    }

    public void setId(String path) {
        this.path = path;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "ShortUrl{" +
                "path=" + path +
                ", link='" + link + '\'' +
                '}';
    }
}

package com.urlshortner.urlshortner.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "url")
public class URL {

    @Id
    @Column(length = 255, name = "path")
    private String path;

    @Column(nullable = false, columnDefinition = "TEXT", name = "link")
    private String link;

    @OneToMany(mappedBy = "url", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Click> clicks;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Set<Click> getClicks() {
        return clicks;
    }

    public void setClicks(Set<Click> clicks) {
        this.clicks = clicks;
    }
}

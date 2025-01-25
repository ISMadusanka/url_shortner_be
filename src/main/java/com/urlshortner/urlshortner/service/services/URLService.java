package com.urlshortner.urlshortner.service.services;

import com.urlshortner.urlshortner.entity.URL;

import java.util.Optional;

public interface URLService {
    URL saveUrl(URL url);
    Optional<URL> findByPath(String path);
}

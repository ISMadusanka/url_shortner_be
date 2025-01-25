package com.urlshortner.urlshortner.service;

import com.urlshortner.urlshortner.dao.URLRepository;
import com.urlshortner.urlshortner.entity.URL;
import com.urlshortner.urlshortner.service.services.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class URLServiceImpl implements URLService {

    private URLRepository urlRepository;

    @Autowired
    public URLServiceImpl(URLRepository urlRepository){
        this.urlRepository=urlRepository;
    }

    @Override
    public URL saveUrl(URL url) {
        return urlRepository.save(url);
    }

    @Override
    public Optional<URL> findByPath(String path) {
        return urlRepository.findById(path);
    }
}

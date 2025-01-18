package com.urlshortner.urlshortner.service;

import com.urlshortner.urlshortner.dao.ShortUrlRepository;
import com.urlshortner.urlshortner.entity.ShortUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShortUrlServiceImpl implements ShortUrlService{

    private ShortUrlRepository shortUrlRepository;

    @Autowired
    public ShortUrlServiceImpl(ShortUrlRepository shortUrlRepository){
        this.shortUrlRepository=shortUrlRepository;
    }

    @Override
    public ShortUrl findById(String path) {
        Optional<ShortUrl>result =shortUrlRepository.findById(path);
        ShortUrl shortUrl=null;
        if (result.isPresent()){
            shortUrl =result.get();
        }else{
            throw new RuntimeException("Not found path: "+path);
        }
        return shortUrl;
    }

    @Override
    public ShortUrl createLink(ShortUrl shortUrl){
        return shortUrlRepository.save(shortUrl);

    }
}

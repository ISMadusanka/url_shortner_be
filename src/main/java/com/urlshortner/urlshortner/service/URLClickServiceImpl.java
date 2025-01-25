package com.urlshortner.urlshortner.service;

import com.urlshortner.urlshortner.dao.URLClickRepository;
import com.urlshortner.urlshortner.entity.Click;
import com.urlshortner.urlshortner.service.services.URLClickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class URLClickServiceImpl implements URLClickService {

    private URLClickRepository urlClickRepository;

    @Autowired
    public URLClickServiceImpl(URLClickRepository urlClickRepository){
        this.urlClickRepository=urlClickRepository;
    }

    @Override
    public void saveClick(Click click) {
        urlClickRepository.save(click);
    }

    @Override
    public long countTotalClicks(String path) {
        return urlClickRepository.countClickByUrl(path);
    }

    @Override
    public List<Object[]> getClicksByDevice(String path) {
        return urlClickRepository.countClicksByDevice(path);
    }

    @Override
    public List<Object[]> getClicksByCountry(String path) {
        return urlClickRepository.countClicksByCountry(path);
    }
}

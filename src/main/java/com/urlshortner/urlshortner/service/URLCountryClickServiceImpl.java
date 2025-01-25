package com.urlshortner.urlshortner.service;

import com.urlshortner.urlshortner.dao.URLCountryClickRepository;
import com.urlshortner.urlshortner.entity.URLCountryClick;
import com.urlshortner.urlshortner.service.services.URLCountryClickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLCountryClickServiceImpl implements URLCountryClickService {

    private URLCountryClickRepository urlCountryClickRepository;

    @Autowired
    public URLCountryClickServiceImpl(URLCountryClickRepository urlCountryClickRepository){
        this.urlCountryClickRepository=urlCountryClickRepository;
    }

    @Override
    public URLCountryClick saveCountryClicks(URLCountryClick countryClick) {
        return urlCountryClickRepository.save(countryClick);
    }
}

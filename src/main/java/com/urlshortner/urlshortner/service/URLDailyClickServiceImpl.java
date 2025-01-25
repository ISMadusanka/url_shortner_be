package com.urlshortner.urlshortner.service;

import com.urlshortner.urlshortner.dao.URLDailyClickRepository;
import com.urlshortner.urlshortner.entity.URLDailyClick;
import com.urlshortner.urlshortner.service.services.URLDailyClickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLDailyClickServiceImpl implements URLDailyClickService {

    private URLDailyClickRepository urlDailyClickRepository;

    @Autowired
    public URLDailyClickServiceImpl(URLDailyClickRepository urlDailyClickRepository){
        this.urlDailyClickRepository=urlDailyClickRepository;
    }

    @Override
    public URLDailyClick saveDailyClicks(URLDailyClick urlDailyClick) {
        return urlDailyClickRepository.save(urlDailyClick);
    }
}

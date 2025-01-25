package com.urlshortner.urlshortner.service;

import com.urlshortner.urlshortner.dao.URLDeviceClickRepository;
import com.urlshortner.urlshortner.entity.URLDeviceClick;
import com.urlshortner.urlshortner.service.services.URLDeviceClickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLDeviceClickServiceImpl implements URLDeviceClickService {

    private URLDeviceClickRepository urlDeviceClickRepository;

    @Autowired
    public URLDeviceClickServiceImpl(URLDeviceClickRepository urlDeviceClickRepository){
        this.urlDeviceClickRepository=urlDeviceClickRepository;
    }

    @Override
    public URLDeviceClick saveDeviceClicks(URLDeviceClick deviceClick) {
        return urlDeviceClickRepository.save(deviceClick);
    }
}

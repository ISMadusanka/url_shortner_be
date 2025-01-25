package com.urlshortner.urlshortner.service.services;

import com.urlshortner.urlshortner.entity.URLDailyClick;
import com.urlshortner.urlshortner.entity.URLDeviceClick;

public interface URLDeviceClickService {
    URLDeviceClick saveDeviceClicks(URLDeviceClick deviceClick);
}

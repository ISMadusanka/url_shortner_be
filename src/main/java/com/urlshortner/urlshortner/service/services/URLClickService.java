package com.urlshortner.urlshortner.service.services;

import com.urlshortner.urlshortner.entity.Click;

import java.util.List;
import java.util.Objects;

public interface URLClickService {
    void saveClick(Click click);
    long countTotalClicks(String path);
    List<Object[]> getClicksByDevice(String path);
    List<Object[]> getClicksByCountry(String path);

}

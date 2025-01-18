package com.urlshortner.urlshortner.service;

import com.urlshortner.urlshortner.entity.ShortUrl;

public interface ShortUrlService {
    ShortUrl findById(String path);
    ShortUrl createLink(ShortUrl shortUrl);
}

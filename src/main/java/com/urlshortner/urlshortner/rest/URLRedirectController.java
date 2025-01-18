package com.urlshortner.urlshortner.rest;

import com.urlshortner.urlshortner.entity.ShortUrl;
import com.urlshortner.urlshortner.service.ShortUrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class URLRedirectController {
    private ShortUrlService shortUrlService;

    @Autowired
    public URLRedirectController(ShortUrlService shortUrlService){
        this.shortUrlService=shortUrlService;
    }

    @GetMapping("/{path}")
    public void autoDirect(@PathVariable String path, HttpServletResponse response) throws IOException {
        ShortUrl shortUrl = shortUrlService.findById(path);
        String redirectUrl = shortUrl.getLink();
        response.sendRedirect(redirectUrl);
    }
}

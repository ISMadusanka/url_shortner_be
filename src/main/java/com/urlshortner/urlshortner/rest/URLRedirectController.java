package com.urlshortner.urlshortner.rest;

import com.urlshortner.urlshortner.entity.Click;
import com.urlshortner.urlshortner.entity.ShortUrl;
import com.urlshortner.urlshortner.entity.URL;
import com.urlshortner.urlshortner.entity.enums.DeviceType;
import com.urlshortner.urlshortner.rest.response.StatsResponse;
import com.urlshortner.urlshortner.service.ShortUrlService;
import com.urlshortner.urlshortner.service.services.URLClickService;
import com.urlshortner.urlshortner.service.services.URLService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/")
public class URLRedirectController {
    private ShortUrlService shortUrlService;
    private URLService urlService;
    private URLClickService urlClickService;



    @Autowired
    public URLRedirectController(ShortUrlService shortUrlService, URLService urlService, URLClickService urlClickService){
        this.shortUrlService=shortUrlService;
        this.urlService=urlService;
        this.urlClickService=urlClickService;
    }

//    @GetMapping("/{path}")
//    public void autoDirect(@PathVariable String path, HttpServletResponse response) throws IOException {
//        ShortUrl shortUrl = shortUrlService.findById(path);
//        String redirectUrl = shortUrl.getLink();
//        response.sendRedirect(redirectUrl);
//    }





    @GetMapping("/{path}")
    public RedirectView redirectURL(@PathVariable String path,
                                    @RequestHeader(value = "User-Agent", required = false) String userAgent,
                                    @RequestHeader(value = "X-Forwarded-For", required = false) String ipAddress,
                                    @RequestHeader(value = "Geo-Country", required = false) String country) {
        // Find the original URL
        URL url = urlService.findByPath(path).orElseThrow(() -> new RuntimeException("URL not found"));

        // Log the click
        Click click = new Click();
        click.setUrl(url);
        click.setDeviceType(determineDeviceType(userAgent));
        click.setCountry(country != null ? country : "Unknown");
        click.setClickTime(LocalDateTime.now());
        urlClickService.saveClick(click);
        System.out.println("ip"+ipAddress);
        // Redirect to the original URL
        return new RedirectView(url.getLink());
    }

    private DeviceType determineDeviceType(String userAgent) {
        if (userAgent == null) return DeviceType.other;
        if (userAgent.toLowerCase().contains("mobile")) return DeviceType.mobile;
        if (userAgent.toLowerCase().contains("tablet")) return DeviceType.mobile;
        return DeviceType.desktop;
    }
}

package com.urlshortner.urlshortner.rest;

import com.urlshortner.urlshortner.entity.ShortUrl;
import com.urlshortner.urlshortner.entity.URL;
import com.urlshortner.urlshortner.rest.response.StatsResponse;
import com.urlshortner.urlshortner.service.ShortUrlService;
import com.urlshortner.urlshortner.service.services.URLClickService;
import com.urlshortner.urlshortner.service.services.URLService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.SecureRandom;

@RestController
@RequestMapping("/api")
public class URLController {
    private ShortUrlService shortUrlService;

    private URLService urlService;
    private URLClickService urlClickService;


    @Autowired
    public URLController(ShortUrlService shortUrlService, URLService urlService, URLClickService urlClickService){
        this.shortUrlService=shortUrlService;
        this.urlService=urlService;
        this.urlClickService=urlClickService;
    }

    @GetMapping("/test")
    public String sayHi(){
        return "hi";
    }

    @GetMapping("/{path}/stats")
    public ResponseEntity<?> getURLStats(@PathVariable String path) {

        try {

            // Total clicks
            long totalClicks = urlClickService.countTotalClicks(path);

            // Clicks by device
            var clicksByDevice = urlClickService.getClicksByDevice(path);

            // Clicks by country
            var clicksByCountry = urlClickService.getClicksByCountry(path);

            // Return stats as a response
            return ResponseEntity.ok(new StatsResponse(totalClicks, clicksByDevice, clicksByCountry));


        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.ok("not found");
        }
    }
//
//    @PostMapping("/generate")
//    public ShortUrl createShortUrl(@RequestBody ShortUrl shortUrl){
//
//        // Define the characters to use in the random string (only a-z and A-Z)
//        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//        SecureRandom random = new SecureRandom();
//
//        StringBuilder sb = new StringBuilder(4);
//        for (int i = 0; i < 4; i++) {
//            int index = random.nextInt(CHARACTERS.length());
//            sb.append(CHARACTERS.charAt(index));
//        }
//        String pid = sb.toString();
//
//        shortUrl.setId(pid);
//
//        ShortUrl res = shortUrlService.createLink(shortUrl);
//        res.setLink("myweb.com");
//
//        return res;
//
//
//    }

    @PostMapping("/short")
    public ResponseEntity<String> shortUrl(@RequestBody URL url){
        try{


        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom random = new SecureRandom();

        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        String pid = sb.toString();

        URL urlDb =new URL();
        urlDb.setLink(url.getLink());
        urlDb.setPath(pid);

        urlService.saveUrl(urlDb);

        return ResponseEntity.ok("Shortened URL: www.localhost.com/8080/"+ pid);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.ok(e.getMessage());
        }
    }






}

package com.urlshortner.urlshortner.dao;

import com.urlshortner.urlshortner.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, String> {
}

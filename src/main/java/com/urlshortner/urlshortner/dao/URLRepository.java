package com.urlshortner.urlshortner.dao;

import com.urlshortner.urlshortner.entity.URL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLRepository extends JpaRepository<URL,String> {
}

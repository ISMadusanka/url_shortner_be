package com.urlshortner.urlshortner.dao;

import com.urlshortner.urlshortner.entity.Click;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface URLClickRepository extends JpaRepository<Click, Long> {

    // Query to count clicks for a specific URL
    @Query("SELECT COUNT(c) FROM Click c WHERE c.url.path = :path")
    long countClickByUrl(@Param("path") String path);

    // Query to count clicks by device type
    @Query("SELECT c.deviceType, COUNT(c) FROM Click c WHERE c.url.path = :path GROUP BY c.deviceType")
    List<Object[]> countClicksByDevice(@Param("path") String path);

    // Query to count clicks by country
    @Query("SELECT c.country, COUNT(c) FROM Click c WHERE c.url.path = :path GROUP BY c.country")
    List<Object[]> countClicksByCountry(@Param("path") String path);
}

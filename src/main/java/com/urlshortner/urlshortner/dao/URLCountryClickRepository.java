package com.urlshortner.urlshortner.dao;

import com.urlshortner.urlshortner.entity.URLCountryClick;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLCountryClickRepository extends JpaRepository<URLCountryClick, Long> {
}

package com.urlshortner.urlshortner.dao;

import com.urlshortner.urlshortner.entity.URLCountryClick;
import com.urlshortner.urlshortner.entity.URLDailyClick;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLDailyClickRepository extends JpaRepository<URLDailyClick,Long> {
}

package com.urlshortner.urlshortner.dao;

import com.urlshortner.urlshortner.entity.URLDeviceClick;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLDeviceClickRepository extends JpaRepository<URLDeviceClick,Long> {
}

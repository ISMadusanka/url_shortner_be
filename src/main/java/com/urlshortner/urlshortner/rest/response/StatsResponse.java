package com.urlshortner.urlshortner.rest.response;

import java.util.List;

public class StatsResponse {
    private long totalClicks;
    private List<Object[]> clicksByDevice;
    private List<Object[]> clicksByCountry;

    public StatsResponse(long totalClicks, List<Object[]> clicksByDevice, List<Object[]> clicksByCountry) {
        this.totalClicks = totalClicks;
        this.clicksByDevice = clicksByDevice;
        this.clicksByCountry = clicksByCountry;
    }

    // Getters and Setters
    public long getTotalClicks() {
        return totalClicks;
    }

    public void setTotalClicks(long totalClicks) {
        this.totalClicks = totalClicks;
    }

    public List<Object[]> getClicksByDevice() {
        return clicksByDevice;
    }

    public void setClicksByDevice(List<Object[]> clicksByDevice) {
        this.clicksByDevice = clicksByDevice;
    }

    public List<Object[]> getClicksByCountry() {
        return clicksByCountry;
    }

    public void setClicksByCountry(List<Object[]> clicksByCountry) {
        this.clicksByCountry = clicksByCountry;
    }
}


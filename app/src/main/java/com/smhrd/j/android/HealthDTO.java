package com.smhrd.j.android;

public class HealthDTO {
    private String date;
    private String health_check;
    private String health_spinner;
    private String health_daily;
    private String id;

    public HealthDTO(String date, String health_check, String health_spinner, String health_daily, String id) {
        this.date = date;
        this.health_check = health_check;
        this.health_spinner = health_spinner;
        this.health_daily = health_daily;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHealth_check() {
        return health_check;
    }

    public void setHealth_check(String health_check) {
        this.health_check = health_check;
    }

    public String getHealth_spinner() {
        return health_spinner;
    }

    public void setHealth_spinner(String health_spinner) {
        this.health_spinner = health_spinner;
    }

    public String getHealth_daily() {
        return health_daily;
    }

    public void setHealth_daily(String health_daily) {
        this.health_daily = health_daily;
    }
}

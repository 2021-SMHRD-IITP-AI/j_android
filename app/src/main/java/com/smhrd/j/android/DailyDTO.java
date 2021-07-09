package com.smhrd.j.android;

public class DailyDTO {
    private String daily, sp, ck;

    public DailyDTO(String year, String momth, String day, String daily, String sp, String ck) {

        this.daily = daily;
        this.sp = sp;
        this.ck = ck;
    }



    public String getDaily() {
        return daily;
    }

    public void setDaily(String daily) {
        this.daily = daily;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getCk() {
        return ck;
    }

    public void setCk(String ck) {
        this.ck = ck;
    }
}

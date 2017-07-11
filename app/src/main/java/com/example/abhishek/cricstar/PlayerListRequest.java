package com.example.abhishek.cricstar;

/**
 * Created by abhishek on 11/07/17.
 */

public class PlayerListRequest {
    public String getSpikey() {
        return spikey;
    }

    public void setSpikey(String spikey) {
        this.spikey = spikey;
    }

    public Long getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(Long unique_id) {
        this.unique_id = unique_id;
    }

    private String spikey;
    private Long unique_id;

}

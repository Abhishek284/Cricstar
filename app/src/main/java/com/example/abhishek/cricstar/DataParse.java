package com.example.abhishek.cricstar;

import android.widget.SimpleCursorAdapter;

import com.google.gson.annotations.SerializedName;

import java.sql.Array;
import java.util.List;

/**
 * Created by abhishek on 04/07/17.
 */

public class DataParse {

    private String v;
    private int ttl;
    private int creditsLeft;
    private List<Matches> matches;
    public Provider provider;

    public DataParse.Provider getProvider() {
        return provider;
    }

    public void setProvider(DataParse.Provider provider) {
        this.provider = provider;
    }

    public class Provider{

        private String source;
        private String url;
        private String pubDate;

        public String getSource() {
            return source;
        }

        public void setSource(String source) {

            this.source = source;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPubDate() {
            return pubDate;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }


    }


    public List<Matches> getMatchesList() {
        return matches;
    }

    public void setMatchesList(List<Matches> matchesList) {
        this.matches = matchesList;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public int getCreditsLeft() {
        return creditsLeft;
    }

    public void setCreditsLeft(int creditsLeft) {
        this.creditsLeft = creditsLeft;
    }


    public class Matches{
        private long unique_id;
        private String date;



        private boolean squad;
        private boolean matchStarted;
        @SerializedName("team-1")
        public String team1;
        @SerializedName("team-2")
        private String team2;


        public String getTeam1() {
            return team1;
        }

        public void setTeam1(String team1) {
            this.team1 = team1;
        }

        public String getTeam2() {
            return team2;
        }

        public void setTeam2(String team2) {
            this.team2 = team2;
        }
        public long getUnique_id() {
            return unique_id;
        }

        public void setUnique_id(long unique_id) {
            this.unique_id = unique_id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public boolean isSquad() {
            return squad;
        }

        public void setSquad(boolean squad) {
            this.squad = squad;
        }

        public boolean isMatchStarted() {
            return matchStarted;
        }

        public void setMatchStarted(boolean matchStarted) {
            this.matchStarted = matchStarted;
        }



    }





}

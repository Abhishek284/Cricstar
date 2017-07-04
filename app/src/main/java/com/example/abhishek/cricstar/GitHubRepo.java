package com.example.abhishek.cricstar;

import android.widget.SimpleCursorAdapter;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by abhishek on 04/07/17.
 */

public class GitHubRepo {

    private List<Matches> matches;

    public List<Matches> getMatchesList() {
        return matches;
    }

    public void setMatchesList(List<Matches> matchesList) {
        this.matches = matchesList;
    }

    private class Matches{
        private long unique_id;
        private String date;
        private boolean squad;

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

        private boolean matchStarted;


    }



}

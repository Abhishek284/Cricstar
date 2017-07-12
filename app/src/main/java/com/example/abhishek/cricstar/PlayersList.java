package com.example.abhishek.cricstar;

import java.util.List;

/**
 * Created by abhishek on 11/07/17.
 */

public class PlayersList {
    public List<Squad> getSquad() {
        return squad;
    }

    public void setSquad(List<Squad> squad) {
        this.squad = squad;
    }

    public List<Squad> squad;

    public class Squad{
        public String name;

        public List<Players> getPlayers() {
            return players;
        }

        public void setPlayers(List<Players> players) {
            this.players = players;
        }

        public String getCountryName() {
            return name;
        }

        public void setCountryName(String countryName) {
            this.name = countryName;
        }

        public List<Players> players;



        public class Players{
            public String pid;

            public String getPlayerName() {
                return name;
            }

            public void setPlayerName(String playerName) {
                this.name = playerName;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String name;

        }

    }

}

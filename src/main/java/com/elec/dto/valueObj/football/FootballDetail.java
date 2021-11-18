package com.elec.dto.valueObj.football;

import lombok.Data;

import java.util.Date;

@Data
public class FootballDetail {
    private Fixture fixture;
    private League league;
    private Team teams;
    private Goal goals;
    private Score score;
    @Data
    public static class Fixture{
        private Long id;
        private String referee;
        private String timezone;
        private String date;
        private Date timestamp;
        private Periods periods;
        private Venue venue;
        private Status status;
        private String oddsInfo;
        @Data
        public static class Periods{
            private Date first;
            private Date second;
        }
        @Data
        public static class Venue{
            private Long id;
            private String name;
            private String city;
        }
        @Data
        public static class Status{

        }

    }
    @Data
    public static class League{
        private Long id;
        private String name;
        private String country;
        private String logo;
        private String flag;
        private int season;
        private String round;
    }
    @Data
    public static class Team{
        private SubTeam home;
        private SubTeam away;
        @Data
        public static class SubTeam{
            private Long id;
            private String name;
            private String logo;
            private boolean winner;
        }
    }
    @Data
    public static class Goal{
        private int home;
        private int away;
    }
    @Data
    public static class Score{
        private Goal halftime;
        private Goal fulltime;
        private Goal extratime;
        private Goal penalty;
    }
}

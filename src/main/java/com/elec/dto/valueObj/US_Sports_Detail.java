package com.elec.dto.valueObj;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class US_Sports_Detail {

    private Schedule schedule;

    @Data
    public static class Schedule {
        private Date date;
        private boolean tbaTime;
    }

    private String summary;
    private Details details;

    @Data
    public static class Details {
        private String league;
        private String seasonType;
        private int season;
        private boolean conferenceGame;
        private boolean divisionGame;
    }

    private String status;
    private Teams teams;

    @Data
    public static class Teams {

        private Away away;
        private Home home;

        @Data
        public static class Away {
            private String team;
            private String location;
            private String mascot;
            private String abbreviation;
            private String conference;
            private String division;
        }

        @Data
        public static class Home {
            private String team;
            private String location;
            private String mascot;
            private String abbreviation;
            private String conference;
            private String division;
        }
    }

    private Date lastUpdated;
    private long gameId;
    private Venue venue;

    @Data
    public static class Venue {
        private String name;
        private String city;
        private String state;
        private boolean neutralSite;
    }

    private List<Odds> odds;

    @Data
    public static class Odds {
        private Spread spread;
        private MoneyLine moneyline;
        private Total total;
        private Date openDate;
        private Date lastUpdated;

        @Data
        public static class Spread {
            private Open open;
            private Current current;

            @Data
            public static class Open {
                private double away;
                private double home;
                private int awayOdds;
                private int homeOdds;
            }

            @Data
            public static class Current {
                private double away;
                private double home;
                private int awayOdds;
                private int homeOdds;
            }
        }

        @Data
        public static class MoneyLine {
            private Open open;
            private Current current;

            @Data
            public static class Open {
                private int awayOdds;
                private int homeOdds;
            }

            @Data
            public static class Current {
                private int awayOdds;
                private int homeOdds;
            }
        }

        @Data
        public static class Total {
            private Open open;
            private Current current;

            @Data
            public static class Open {
                private double total;
                private int overOdds;
                private int underOdds;
            }

            @Data
            public static class Current {
                private double total;
                private int overOdds;
                private int underOdds;
            }
        }
    }

    private Scoreboard scoreboard;

    @Data
    public static class Scoreboard {
        private Score score;
        private int currentPeriod;
        private String periodTimeRemaining;

        @Data
        public static class Score {
            private int away;
            private int home;
            private List<Integer> awayPeriods;
            private List<Integer> homePeriods;
        }
    }

}


package com.elec.dto.valueObj.basketball;

import com.elec.dto.valueObj.football.FootballDetail;
import lombok.Data;

import java.util.Date;

@Data
public class BasketDetail {
    private Long id;
    private String date;
    private Date timestamp;
    private String timezone;
    private String stage;
    private String week;
    private FootballDetail.Fixture.Status status;
    private League league;
    private FootballDetail.Team teams;
    private Score scores;
    private String oddsInfo;
    @Data
    public static class Score{
        private SubTeam home;
        private SubTeam away;
        @Data
        public static class SubTeam{
            private Long quarter_1;
            private Long quarter_2;
            private Long quarter_3;
            private Long quarter_4;
            private Long total;
        }
    }
    @Data
    public static class League{
        private Long id;
        private String name;
        private String country;
        private String logo;
        private String flag;
        private String season;
        private String round;
    }
}

package com.elec.dto.valueObj.football;

import lombok.Data;

import java.util.List;

@Data
public class FootballResult{
    private FootballDetail.Fixture fixture;
    private FootballDetail.League league;
    private String update;
    private List<Bookmakers> bookmakers;
    @Data
    public static class Bookmakers{
        private Long id;
        private String name;
        private List<Bets> bets;
        @Data
        public static class Bets{
            private Long id;
            private String name;
            private List<Values> values;
            @Data
            public static class Values{
                private String value;
                private String odd;
            }
        }

    }
}

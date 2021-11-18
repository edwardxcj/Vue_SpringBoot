package com.elec.dto.valueObj;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class GameDetail {
    private String id;
    private String sport_key;
    private String sport_nice;
    private String home_team;
    private Date commence_time;
    private List<String> teams;
    private List<Site> sites;
    @Data
    public static class Site{
        private String site_key;
        private String site_nice;
        private Date last_update;
        private Odds odds;
        @Data
        public static class Odds{
            private List<BigDecimal> h2h;
        }
    }

}

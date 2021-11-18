package com.elec.dto.valueObj.basketball;

import com.elec.dto.valueObj.football.FootballDetail;
import com.elec.dto.valueObj.football.FootballResult;
import lombok.Data;

import java.util.List;
@Data
public class BasketballResult {
    private FootballDetail.League league;
    private List<FootballResult.Bookmakers> bookmakers;
}

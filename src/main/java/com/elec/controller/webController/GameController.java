package com.elec.controller.webController;

import com.elec.dto.GameBetDTO;
import com.elec.dto.UpdateGameDetailDTO;
import com.elec.dto.valueObj.Result;
import com.elec.service.GameSessionHandleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/game/gameSession")
public class GameController {
    @Resource
    private GameSessionHandleService gameSessionHandleService;
    //Get more information about the competition
    @GetMapping("/queryGameDetail")
    public Result<?> queryGameDetail(@RequestParam(value = "gameId") Long gameId){
        return Result.succeed(this.gameSessionHandleService.getDetail(gameId));
    }
    //Save user action (bet)
    @PostMapping("/saveUserOperation")
    public Result<?> saveUserOperation(@RequestBody GameBetDTO gameBetDTO){
        try {
            return Result.succeed(this.gameSessionHandleService.saveUserOperation(gameBetDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.succeed("fail");
        }
    }
    //Updating user operations
    // TODO: 2021/10/16  
    @PostMapping("/updateUserOperation")
    public Result<?> updateUserOperation(){
        return Result.succeed();
    }
    //Get the tournament list
    @PostMapping("/getGameList")
    public Result<?> getGameList(){
        return Result.succeed(this.gameSessionHandleService.getGameList());
    }
    //Update competition Information
    @PostMapping("/updateGameInfo")
    public Result<?> updateGameInfo(@RequestBody UpdateGameDetailDTO updateGameDetailDTO){
        return Result.succeed(this.gameSessionHandleService.updateGameDetail(updateGameDetailDTO));
    }
    //Save the basketball
    @PostMapping("/saveBasketballDetail")
    public Result<?> saveBasketballDetail(){
        return Result.succeed(this.gameSessionHandleService.saveBasketballDetail());
    }
    @PostMapping("/saveUSGamesDetail")
    public Result<?> save_US_Games_Detail(){
        return Result.succeed(this.gameSessionHandleService.saveUSGameDetail());
    }

}

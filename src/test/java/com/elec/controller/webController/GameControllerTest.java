package com.elec.controller.webController;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GameControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void queryGameDetail() throws Exception{
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/game/gameSession/queryGameDetail").param("gameId","1018080618093079").accept(MediaType.APPLICATION_JSON)).andReturn();

        int status = mvcResult.getResponse().getStatus();

        Assert.assertEquals(200,status);

    }


    @Test
    public void getGameList() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/game/gameSession/getGameList").accept(MediaType.APPLICATION_JSON)).andReturn();

        int status = mvcResult.getResponse().getStatus();

        Assert.assertEquals(200,status);
    }


//    @Test
//    public void saveBasketballDetail() throws Exception{
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/game/gameSession/saveBasketballDetail").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//
//        Assert.assertEquals(200,status);
//    }

    @Test
    public void save_US_Games_Detail() throws Exception{
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/game/gameSession/saveUSGamesDetail").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();

        Assert.assertEquals(200,status);
    }
}
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
public class PostsControllerTest {

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
    public void getPostDetail() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/save/post/getPostDetail").param("postId","1031083848251009").accept(MediaType.APPLICATION_JSON)).andReturn();

        int status = mvcResult.getResponse().getStatus();

        Assert.assertEquals(200,status);
    }

    @Test
    public void updatePostInfo() throws Exception{
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/save/post/updatePostInfo").accept(MediaType.APPLICATION_JSON)).andReturn();

        int status = mvcResult.getResponse().getStatus();

        Assert.assertEquals(200,status);
    }

    @Test
    public void getPostList() throws Exception{
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/save/post/getPostList").accept(MediaType.APPLICATION_JSON)).andReturn();

        int status = mvcResult.getResponse().getStatus();

        Assert.assertEquals(200,status);
    }
}
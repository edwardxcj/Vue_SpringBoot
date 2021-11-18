package com.elec.controller;

import com.alibaba.fastjson.JSONObject;
import com.elec.api.HttpRequestA;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("elec/api")
public class ApiTestController {
//    @Resource
//    private HttpRequest httpRequest;
    @GetMapping("/covidApi")
    public String getCovidMessage(@RequestParam(value = "url") String url){
        JSONObject object = new JSONObject();
        String param = "x-rapidapi-host=worldometer-covid-19.p.rapidapi.com&x-rapidapi-key=77bb1ccd20mshed85a95ffefdbebp187d43jsn4773d71cca23";
        object.fluentPut("x-rapidapi-host", "worldometer-covid-19.p.rapidapi.com");
        object.fluentPut("x-rapidapi-key", "77bb1ccd20mshed85a95ffefdbebp187d43jsn4773d71cca23");
        return HttpRequestA.sendGet(url,param);
    }
}

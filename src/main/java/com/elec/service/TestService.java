package com.elec.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.elec.api.HttpRequestA;
import com.elec.component.DateGetComponent;
import com.elec.dto.valueObj.basketball.BasketDetail;
import com.elec.dto.valueObj.football.FirstLevel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final String date = DateGetComponent.getCurrentDate();

    private final HttpHeaders headers = new HttpHeaders();
    boolean saveFootballDetail(){
        String uri = "https://odds.p.rapidapi.com/v1/odds?sport=soccer_epl&region=uk&mkt=h2h&dateFormat=iso&oddsFormat=decimal";
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-host","odds.p.rapidapi.com");
        headers.add("x-rapidapi-key","77bb1ccd20mshed85a95ffefdbebp187d43jsn4773d71cca23");
        ResponseEntity<String> result = HttpRequestA.getResult(headers, uri);
        return true;
    }

    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance(); // get current instance of the calendar
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String date = formatter.format(calendar.getTime());
//        String uri = "https://api-football-v1.p.rapidapi.com/v3/fixtures?date="+date+"&league=39&season=2021";
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("x-rapidapi-host","api-football-v1.p.rapidapi.com");
//        headers.add("x-rapidapi-key","77bb1ccd20mshed85a95ffefdbebp187d43jsn4773d71cca23");
//        ResponseEntity<String> result = HttpRequestA.getResult(headers, uri);
//        FirstLevel<?> result1 = JSONObject.parseObject(result.getBody(),FirstLevel.class);
//
//        if (null != result1){
//            final Object data = result1.getResponse();
//            JSONArray array = JSONObject.parseArray(JSONObject.toJSONString(data));
//            List<FootballDetail> list = array.toJavaList(FootballDetail.class);
//            list.forEach(l->{
//                Long id = l.getFixture().getId();
//                String uri1 = "https://api-football-v1.p.rapidapi.com/v3/odds?fixture="+id.toString()+"&bookmaker=6";
//                ResponseEntity<String> result2 = HttpRequestA.getResult(headers, uri1);
//                FirstLevel<?> result3 = JSONObject.parseObject(result2.getBody(),FirstLevel.class);
//                if (null !=result3){
//                    final Object response = result3.getResponse();
//                    JSONArray array1 = JSONObject.parseArray(JSONObject.toJSONString(response));
//                    List<FootballResult> list1 = array1.toJavaList(FootballResult.class);
//                    String win = list1.get(0).getBookmakers().get(0).getBets().get(0).getValues().get(0).getOdd();
//                    String draw = list1.get(0).getBookmakers().get(0).getBets().get(0).getValues().get(1).getOdd();
//                    String lose = list1.get(0).getBookmakers().get(0).getBets().get(0).getValues().get(2).getOdd();
//                    l.getFixture().setOddsInfo(win+":"+draw+":"+lose+":");
//                }
//            });
//            this.gameSessionRepository.saveFootballGameDetail(list);
//        list.forEach(a->{
//
//        });
//        int i = 0;



//        final Object o =array.get(0);
//        try {
//            final FootballResult<?> footballResult = JSONObject.parseObject(o.toString(), FootballResult.class);
//            final Object fixture = footballResult.getFixture();
//            final Object goals = footballResult.getGoals();
//            JSONObject object = (JSONObject) goals;
//            final int home = (int) object.get("home");
//            final int away = (int) object.get("away");
//            System.out.println(home+":"+away);
////            System.out.println("----------------");
////            System.out.println(fixture);
//        }catch (Exception e){
//            return;

//        Long s = 1634392800L;
//        Date date = new Date(s*1000);
//        final long time = date.getTime();
//
//        System.out.println(date);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
////        String date = simpleDateFormat.format(new Date());
//
//        Calendar calendar = new GregorianCalendar();
//
//        calendar.setTime(new Date());
//
//        calendar.add(calendar.DATE,-1);
//
//        String date2= simpleDateFormat.format(calendar.getTime());
//
//        System.out.println(date2);

//        String date = DateGetComponent.getCurrentDate();
        String date = "2021-01-21";
        HttpHeaders headers = new HttpHeaders();

        String uri = "https://api-basketball.p.rapidapi.com/games?season=2020-2021&league=12&date="+date;
        headers.add("x-rapidapi-host","api-basketball.p.rapidapi.com");
        headers.add("x-rapidapi-key","77bb1ccd20mshed85a95ffefdbebp187d43jsn4773d71cca23");
        ResponseEntity<String> result = HttpRequestA.getResult(headers, uri);
        FirstLevel<?> result1 = JSONObject.parseObject(result.getBody(),FirstLevel.class);
        if (null!=result1){
            final Object response = result1.getResponse();
            JSONArray array = JSONObject.parseArray(JSONObject.toJSONString(response));
            List<BasketDetail> list = array.toJavaList(BasketDetail.class);
            System.out.println(JSONObject.toJSONString(list));
        }

    }
}

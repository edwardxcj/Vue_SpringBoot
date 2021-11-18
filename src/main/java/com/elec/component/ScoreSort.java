package com.elec.component;

import com.elec.dal.pojo.UserInfo;
import com.elec.response.RankListResponse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScoreSort {
    public static List<RankListResponse> sort(List<UserInfo> userInfos){
        List<RankListResponse> list = new ArrayList<>();
        userInfos.forEach(userInfo -> {
            RankListResponse response = new RankListResponse();
            response.setCurrScores(userInfo.getCurrScores());
            response.setUserName(userInfo.getUserName());
        });
        sortList(userInfos);
        return list;
    }
    private static void sortList(List<UserInfo> userInfos){
        Comparator<UserInfo> comparator = new Comparator<UserInfo>() {
            @Override
            public int compare(UserInfo o1, UserInfo o2) {
                if (o1.getCurrScores().equals(o2.getCurrScores()) ){
                    return -1;
                } else if (o1.getCurrScores() < o2.getCurrScores()){
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        userInfos.sort(comparator);
    }
}

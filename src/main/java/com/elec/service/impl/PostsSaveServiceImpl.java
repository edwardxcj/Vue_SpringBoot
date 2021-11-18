package com.elec.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.elec.component.GenerateId;
import com.elec.dal.pojo.PostInfo;
import com.elec.dal.pojo.UserInfo;
import com.elec.dto.PostSaveDTO;
import com.elec.repository.PostRepository;
import com.elec.repository.UserRepository;
import com.elec.service.PostsSaveService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostsSaveServiceImpl implements PostsSaveService {
    @Resource
    private PostRepository postRepository;
    @Resource
    private UserRepository userRepository;
    @Override
    public Boolean savePostInfo(PostSaveDTO postSaveDTO) {
        String postId = GenerateId.getGeneratID().toString();
        postSaveDTO.setPostId(postId);
        final Boolean save = this.postRepository.save(postSaveDTO);
        if (save){
            final UserInfo userInfo = this.userRepository.queryUserInfo(postSaveDTO.getUserName());
            if (StringUtils.isNotBlank(userInfo.getPostList())){
                JSONArray array = JSONArray.parseArray(userInfo.getPostList());
                List<String> list = array.toJavaList(String.class);
                list.add(postId);
                userInfo.setPostList(JSONObject.toJSONString(list));
            }else {
                List<String> list = new ArrayList<>();
                list.add(postId);
                userInfo.setPostList(JSONObject.toJSONString(list));
            }
            this.userRepository.updateUserInfo(userInfo);
        }
        return true;
    }

    @Override
    public PostSaveDTO queryPostInfoById(String postId) {
        return this.postRepository.queryDetailById(postId);
    }

    @Override
    public List<PostInfo> getPostList() {

        List<PostInfo> list =  this.postRepository.getPostList();//这个list就是数据源
        int listNum = 20;
        int returnNum = list.size();
        //如果listNum大于数据源list，直接返回list数据源全部数据
        if(listNum < list.size()) {
            returnNum = listNum;
        }
        int randomIndex =  (int) (Math.random() * (list.size()-returnNum));
        List<PostInfo> resultList= new ArrayList<>();
        for (int i = randomIndex; i < randomIndex+returnNum; i++) {
            resultList.add(list.get(i));
        }
        return resultList;
    }

}

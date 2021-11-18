package com.elec.service;

import com.elec.dal.pojo.PostInfo;
import com.elec.dto.PostSaveDTO;

import java.util.List;

public interface PostsSaveService {
    /**
     * 保存帖子信息
     * @param postSaveDTO
     * @return
     */
    Boolean savePostInfo(PostSaveDTO postSaveDTO);

    /**
     * 根据id查询帖子详情
     * @param postId
     * @return
     */
    PostSaveDTO queryPostInfoById(String postId);

    /**
     * 获取帖子列表
     * @return
     */
    List<PostInfo> getPostList();
}

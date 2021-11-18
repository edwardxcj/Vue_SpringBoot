package com.elec.repository;

import com.elec.dal.pojo.PostInfo;
import com.elec.dto.PostSaveDTO;

import java.util.List;

public interface PostRepository {
    /**
     * save the info of the post
     * @param postSaveDTO
     * @return
     */
    Boolean save(PostSaveDTO postSaveDTO);

    /**
     * query the detail of the post
     * @param postId
     * @return
     */
    PostSaveDTO queryDetailById(String postId);

    /**
     * get the list of posts
     * @return
     */
    List<PostInfo> getPostList();
}

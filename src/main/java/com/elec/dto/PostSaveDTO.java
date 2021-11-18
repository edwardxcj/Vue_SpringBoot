package com.elec.dto;

import lombok.Data;

@Data
public class PostSaveDTO {
    /**
     * user name
     */
    private String userName;

    /**
     * type of the post like basketball
     */
    private String gameType;

    /**
     * title of the post
     */
    private String title;

    /**
     * content of the post
     */
    private String content;

    /**
     * comments of the post
     */
    private String comment;

    /**
     * Only id of the post
     */
    private String postId;
}

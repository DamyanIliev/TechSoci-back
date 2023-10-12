package com.damyan.TECHSOCI.model;

import lombok.Data;

@Data
public class CreateCommentRequest {
    private String text;

    private long postId;
}

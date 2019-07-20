package com.b127.demo.dto;


import java.util.Date;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 6/24/2019
 * Time: 9:59 PM}
 */


public class CommentDTO extends SuperDTO {

    private int commentId;
    private int userId;
    private int feedId;
    private String body;
    private int likes;
    private Date createdTime;

    public CommentDTO() {
    }

    public CommentDTO(int commentId, int userId, int feedId, String body, int likes, Date createdTime) {
        this.commentId = commentId;
        this.userId = userId;
        this.feedId = feedId;
        this.body = body;
        this.likes = likes;
        this.createdTime = createdTime;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFeedId() {
        return feedId;
    }

    public void setFeedId(int feedId) {
        this.feedId = feedId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}

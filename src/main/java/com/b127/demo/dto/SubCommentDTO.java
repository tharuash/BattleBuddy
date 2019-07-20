package com.b127.demo.dto;




import com.b127.demo.entity.Comment;
import com.b127.demo.entity.User;

import java.util.Date;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 6/24/2019
 * Time: 10:00 PM}
 */


public class SubCommentDTO extends SuperDTO {

    private int subCommentId;
    private User user;
    private Comment comment;
    private String body;
    private int likes;
    private Date createdTime;

    public SubCommentDTO() {
    }

    public SubCommentDTO(int subCommentId, User user, Comment comment, String body, int likes, Date createdTime) {
        this.subCommentId = subCommentId;
        this.user = user;
        this.comment = comment;
        this.body = body;
        this.likes = likes;
        this.createdTime = createdTime;
    }

    public int getSubCommentId() {
        return subCommentId;
    }

    public void setSubCommentId(int subCommentId) {
        this.subCommentId = subCommentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
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

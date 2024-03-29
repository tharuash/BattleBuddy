package com.b127.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subcomment")
public class SubComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sub_comment_id")
    private int subCommentId;


    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "comment_id",referencedColumnName = "comment_id")
    private Comment comment;

    @Column(name = "body")
    private String body;

    @Column(name = "likes")
    private int likes;

    @Column(name = "created_time")
    private Date createdTime;

    public SubComment() {
    }

    public SubComment(User userId, Comment commentId, String body, int likes, Date createdTime) {
        this.user = userId;
        this.comment = commentId;
        this.body = body;
        this.likes = likes;
        this.createdTime = createdTime;
    }

    public SubComment(int subCommentId, User user, Comment comment, String body, int likes, Date createdTime) {
        this.subCommentId=subCommentId;
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

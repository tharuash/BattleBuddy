package com.b127.demo.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private int commentId;


    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "feed_id",referencedColumnName = "feed_id")
    private Feed feed;

    @Column(name = "body")
    private String body;

    @Column(name = "likes")
    private int likes;

    @Column(name = "created_time")
    private Date createdTime;

    public Comment() {
    }

    public Comment(User userId, Feed feedId, String body, int likes, Date createdTime) {
        this.user = userId;
        this.feed = feedId;
        this.body = body;
        this.likes = likes;
        this.createdTime = createdTime;
    }

    public Comment(int commentId, User user, Feed feedId, String body, int likes, Date createdTime) {
        this.commentId=commentId;
        this.user = user;
        this.feed = feedId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Feed getFeedId() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
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

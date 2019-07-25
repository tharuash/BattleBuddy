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
    @JoinColumn(name = "post_id",referencedColumnName = "post_id")
    private Post post;

    @Column(name = "body")
    private String body;

    @Column(name = "likes")
    private int likes;

    @Column(name = "created_time")
    private Date createdTime;

    public Comment() {
    }

    public Comment(User userId, Post postId, String body, int likes, Date createdTime) {
        this.user = userId;
        this.post = postId;
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

    public Post getPostId() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
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

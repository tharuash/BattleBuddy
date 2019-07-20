package com.b127.demo.entity;

import javax.persistence.*;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 6/24/2019
 * Time: 12:08 AM}
 */


@Entity
@Table(name = "feed")
public class Feed {

    @Id
    @GeneratedValue()
    @Column(name = "feed_id")
    private int feedId;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User user;

    @Column(name = "title")
    private String title;

    @Column(name = "video")
    private byte[] video;

    @Column(name = "likes")
    private int likes;

    @Column(name = "text")
    private String text;

    public Feed() {
    }

    public Feed(User userId, String title, byte[] video, int likes, String text) {
        this.user = userId;
        this.title = title;
        this.video = video;
        this.likes = likes;
        this.text = text;
    }

    public Feed(int feedId, User user, String title, byte[] video, int likes, String text) {
        this.feedId=feedId;
        this.user = user;
        this.title = title;
        this.video = video;
        this.likes = likes;
        this.text = text;
    }

    public int getFeedId() {
        return feedId;
    }

    public void setFeedId(int feedId) {
        this.feedId = feedId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
        this.video = video;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

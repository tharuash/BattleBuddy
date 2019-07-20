package com.b127.demo.dto;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 6/24/2019
 * Time: 9:59 PM}
 */


public class FeedDTO extends SuperDTO {

    private int feedId;
    private int userId;
    private String title;
    private byte[] video;
    private int likes;
    private String text;

    public FeedDTO() {
    }

    public FeedDTO(int feedId, int userId, String title, byte[] video, int likes, String text) {
        this.feedId = feedId;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

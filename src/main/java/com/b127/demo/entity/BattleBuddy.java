package com.b127.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "battlebuddy")
public class BattleBuddy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "battel_buddy_id")
    private int battleBuddyId;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @Column(name = "console")
    private String console;

    @Column(name = "region")
    private String region;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "voice_chat")
    private int voiceChat;

    @Column(name = "language")
    private String language;

    @Column(name = "text")
    private String text;

    public BattleBuddy() {
    }

    public BattleBuddy(User userId, String console, String region, String gameName, int voiceChat, String language, String text) {
        this.user = userId;
        this.console = console;
        this.region = region;
        this.gameName = gameName;
        this.voiceChat = voiceChat;
        this.language = language;
        this.text = text;
    }

    public BattleBuddy(int battleBuddyId, User user, String console, String region, String gameName, int voiceChat, String language, String text) {
        this.battleBuddyId=battleBuddyId;
        this.user = user;
        this.console = console;
        this.region = region;
        this.gameName = gameName;
        this.voiceChat = voiceChat;
        this.language = language;
        this.text = text;
    }

    public int getBattleBuddyId() {
        return battleBuddyId;
    }

    public void setBattleBuddyId(int battleBuddyId) {
        this.battleBuddyId = battleBuddyId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getVoiceChat() {
        return voiceChat;
    }

    public void setVoiceChat(int voiceChat) {
        this.voiceChat = voiceChat;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

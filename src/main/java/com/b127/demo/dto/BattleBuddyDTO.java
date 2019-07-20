package com.b127.demo.dto;


/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 6/24/2019
 * Time: 9:59 PM}
 */


public class BattleBuddyDTO extends SuperDTO {

    private int battleBuddyId;
    private int userId;
    private String console;
    private String region;
    private String gameName;
    private int voiceChat;
    private String language;
    private String text;

    public BattleBuddyDTO() {
    }

    public BattleBuddyDTO(int battleBuddyId, int userId, String console, String region, String gameName, int voiceChat, String language, String text) {
        this.battleBuddyId = battleBuddyId;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

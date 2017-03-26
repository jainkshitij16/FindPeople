package com.tryout.findpeople;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kshitij on 2017-03-26.
 */
public class ContactinfoPerson {

    private String first_name;
    private String last_name;
    private String full_name;
    private ChatPerson chatPerson;
    private WebsitePerson websitePerson;
    public List<ChatPerson> chatPersonList;
    public List<WebsitePerson> websitePersonList;

    public ContactinfoPerson(ChatPerson chatPerson){
        this.chatPerson = chatPerson;
        chatPersonList = new ArrayList<>();
        websitePersonList = new ArrayList<>();
    }

    public ContactinfoPerson(WebsitePerson websitePerson){
        this.websitePerson = websitePerson;
        chatPersonList = new ArrayList<>();
        websitePersonList = new ArrayList<>();
    }

    public ContactinfoPerson(){
        chatPersonList = new ArrayList<>();
        websitePersonList = new ArrayList<>();
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public ChatPerson getChatPerson() {
        return chatPerson;
    }

    public void setChatPerson(ChatPerson chatPerson) {
        this.chatPerson = chatPerson;
    }

    public WebsitePerson getWebsitePerson() {
        return websitePerson;
    }

    public void setWebsitePerson(WebsitePerson websitePerson) {
        this.websitePerson = websitePerson;
    }
}

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
    private ChatContact chatContact;
    private WebsiteContact websiteContact;
    public List<ChatContact> chatContactList;
    public List<WebsiteContact> websiteContactList;

    public ContactinfoPerson(ChatContact chatContact){
        this.chatContact = chatContact;
        chatContactList = new ArrayList<>();
        websiteContactList = new ArrayList<>();
    }

    public ContactinfoPerson(WebsiteContact websiteContact){
        this.websiteContact = websiteContact;
        chatContactList = new ArrayList<>();
        websiteContactList = new ArrayList<>();
    }

    public ContactinfoPerson(){
        chatContactList = new ArrayList<>();
        websiteContactList = new ArrayList<>();
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

    public ChatContact getChatContact() {
        return chatContact;
    }

    public void setChatContact(ChatContact chatContact) {
        this.chatContact = chatContact;
    }

    public WebsiteContact getWebsiteContact() {
        return websiteContact;
    }

    public void setWebsiteContact(WebsiteContact websiteContact) {
        this.websiteContact = websiteContact;
    }
}

package com.tryout.findpeople;

/**
 * Created by Kshitij on 2017-03-26.
 */
public class ChatContact {
    private String client;
    private String handle;

    public ChatContact(String client, String handle){
        this.client = client;
        this.handle = handle;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }
}

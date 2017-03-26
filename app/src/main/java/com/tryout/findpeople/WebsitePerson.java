package com.tryout.findpeople;

/**
 * Created by Kshitij on 2017-03-26.
 */
public class WebsitePerson {

    private String website;

    /*
        URL are Strings; can be converted to URL for redirecting to website upon a request
     */
    public WebsitePerson(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}

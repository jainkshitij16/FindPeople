package com.tryout.findpeople;

/**
 * Created by Kshitij on 2017-03-26.
 */
public class SocialprofilePerson {

    private String bio_socialprofile;
    private String name_socialprofile;
    private int followers_socialprofile;
    private int following_socialprofile;
    private String usernm_socialprofile;
    private String url_socialprofile;

    public SocialprofilePerson(String name, String username){

        this.name_socialprofile = name;
        this.usernm_socialprofile = username;
    }

    public SocialprofilePerson(){

    }

    public String getBio_socialprofile() {
        return bio_socialprofile;
    }

    public void setBio_socialprofile(String bio_socialprofile) {
        this.bio_socialprofile = bio_socialprofile;
    }

    public String getName_socialprofile() {
        return name_socialprofile;
    }

    public void setName_socialprofile(String name_socialprofile) {
        this.name_socialprofile = name_socialprofile;
    }

    public int getFollowers_socialprofile() {
        return followers_socialprofile;
    }

    public void setFollowers_socialprofile(int followers_socialprofile) {
        this.followers_socialprofile = followers_socialprofile;
    }

    public int getFollowing_socialprofile() {
        return following_socialprofile;
    }

    public void setFollowing_socialprofile(int following_socialprofile) {
        this.following_socialprofile = following_socialprofile;
    }

    public String getUsernm_socialprofile() {
        return usernm_socialprofile;
    }

    public void setUsernm_socialprofile(String usernm_socialprofile) {
        this.usernm_socialprofile = usernm_socialprofile;
    }

    public String getUrl_socialprofile() {
        return url_socialprofile;
    }

    public void setUrl_socialprofile(String url_socialprofile) {
        this.url_socialprofile = url_socialprofile;
    }
}

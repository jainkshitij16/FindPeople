package com.tryout.findpeople;

/**
 * Created by Kshitij on 2017-03-26.
 */
public class OrganizationPerson {

    private boolean isPrimary_org;
    private String name_org;
    private String StDate_org;
    private String EdDate_org;
    private String title_org;
    private boolean isCurrent_org;

    public OrganizationPerson(String name){
        this.name_org = name;
    }

    public boolean isPrimary_org() {
        return isPrimary_org;
    }

    public void setPrimary_org(boolean primary_org) {
        isPrimary_org = primary_org;
    }

    public String getName_org() {
        return name_org;
    }

    public void setName_org(String name_org) {
        this.name_org = name_org;
    }

    public String getStDate_org() {
        return StDate_org;
    }

    public void setStDate_org(String stDate_org) {
        StDate_org = stDate_org;
    }

    public String getEdDate_org() {
        return EdDate_org;
    }

    public void setEdDate_org(String edDate_org) {
        EdDate_org = edDate_org;
    }

    public String getTitle_org() {
        return title_org;
    }

    public void setTitle_org(String title_org) {
        this.title_org = title_org;
    }

    public boolean isCurrent_org() {
        return isCurrent_org;
    }

    public void setCurrent_org(boolean current_org) {
        isCurrent_org = current_org;
    }
}

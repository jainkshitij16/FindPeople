package com.tryout.findpeople;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kshitij on 2017-03-26.
 */

public class Person {

    private static Person person = new Person();
    public List<OrganizationPerson> organizationPersonList;
    public ContactinfoPerson contactinfoPerson;
    public List<SocialprofilePerson> socialprofilePersonList;
    public DemographicPerson demographicPerson;
    public DigitalFootPerson digitalFootPerson;


    /*
        Singleton class as there is always one person hence instance is given
     */
    public static Person getInstance(){
        return person;
    }

    public List<OrganizationPerson> getOrganizationPersonList() {
        return organizationPersonList;
    }

    public void setOrganizationPersonList(List<OrganizationPerson> organizationPersonList) {
        this.organizationPersonList = organizationPersonList;
    }

    public ContactinfoPerson getContactinfoPerson() {
        return contactinfoPerson;
    }

    public void setContactinfoPerson(ContactinfoPerson contactinfoPerson) {
        this.contactinfoPerson = contactinfoPerson;
    }

    public List<SocialprofilePerson> getSocialprofilePersonList() {
        return socialprofilePersonList;
    }

    public void setSocialprofilePersonList(List<SocialprofilePerson> socialprofilePersonList) {
        this.socialprofilePersonList = socialprofilePersonList;
    }

    public DemographicPerson getDemographicPerson() {
        return demographicPerson;
    }

    public void setDemographicPerson(DemographicPerson demographicPerson) {
        this.demographicPerson = demographicPerson;
    }

    public DigitalFootPerson getDigitalFootPerson() {
        return digitalFootPerson;
    }

    public void setDigitalFootPerson(DigitalFootPerson digitalFootPerson) {
        this.digitalFootPerson = digitalFootPerson;
    }

    private Person(){

        organizationPersonList = new ArrayList<>();
        contactinfoPerson = new ContactinfoPerson();
        socialprofilePersonList = new ArrayList<>();
        demographicPerson = new DemographicPerson();
        digitalFootPerson = new DigitalFootPerson();
    }

}

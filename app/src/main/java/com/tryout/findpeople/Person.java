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

    private Person(){
        organizationPersonList = new ArrayList<>();
        contactinfoPerson = new ContactinfoPerson();
        socialprofilePersonList = new ArrayList<>();
        demographicPerson = new DemographicPerson();
        digitalFootPerson = new DigitalFootPerson();
    }

}

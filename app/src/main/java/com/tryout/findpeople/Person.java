package com.tryout.findpeople;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kshitij on 2017-03-26.
 */

public class Person {

    //@TODO: forms a person using the contacts, websites,name, organization, social profiles
    //@TODO: should have a list of social profiles and digital footprint

    private static Person person = new Person();
    public List<OrganizationPerson> organizationPersonList;


    /*
        Singleton class as there is always one person hence instance is given
     */
    public static Person getInstance(){
        return person;
    }

    private Person(){
        organizationPersonList = new ArrayList<>();
    }



}

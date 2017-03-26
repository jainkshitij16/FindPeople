package com.tryout.findpeople;

/**
 * Created by Kshitij on 2017-03-26.
 */

public class Person {

    //@TODO: forms a person using the contacts, websites,name, organization, social profiles

    private static Person person = new Person();

    /*
        Singleton class as there is always one person hence instance is given
     */
    public static Person getInstance(){
        return person;
    }

    private Person(){
    }



}

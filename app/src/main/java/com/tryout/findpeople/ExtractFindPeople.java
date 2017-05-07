package com.tryout.findpeople;


import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Kshitij on 2017-03-16.
 */
public class ExtractFindPeople extends AsyncTask<Void,Void,String> {

    private static final String API_KEY = "apiKey=ff17c55d4e74b27a";
    private static final String API_URL = "https://api.fullcontact.com/v2/person.json?";
    private static final String API_EMAIL = "&email="; // Look up by email
    private static final String API_PHONE = "phone="; // Look up by phone
    private String email;
    private MainActivityFindPeople myActivity;
    public Person person;
    public ContactinfoPerson contactinfoPerson;



/*
    AsyncTask class requires following methods
    Params; type of parameter sent to the task upon execution
    Progress; type of progress units to perform in the background
    Result; type of the result of the background execution

    *Use Void if one of them don't have any primitive or objects*
 */

    public ExtractFindPeople(MainActivityFindPeople act, String email){
        myActivity = act;
        this.email = email;
        person = Person.getInstance();
        contactinfoPerson = new ContactinfoPerson();
    }


    /*
        Parameter matches with Params
        Method states what processes to run in the background
        Uses readStream return the string
        @Request: https://api.fullcontact.com/v2/person.json?apiKey=86bc2cd8905ee179&email=
     */
    @Override
    protected String doInBackground(Void... urls) {
        try{
            // Making a call to the API and lookup using email
            String url_request = API_URL + API_KEY + API_EMAIL + email;
           // System.out.println(url_request); Testing from console by printing
            URL url = new URL(url_request);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            try{
                // Standard process for android for handling https request.
                // Look at Git-hub for improved process.
                InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                readStream(inputStream);
            }
            finally {
                httpURLConnection.disconnect();
            }
        } catch (Exception e){
            Log.e(e.getMessage(),"URL not found");
        }
        return null;
    }

    // Defines what to do after the request is accomplished
    // TODO: pass as person
    protected void onPostExecute(String response) {
        if(response==null) response = "There was an error";
        myActivity.displayDetails(response);
    }

    // Converts InputStream to a string for doInBackground
    // Appends strings to each other and returns them together
    private String readStream(InputStream inputStream) throws IOException{
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = bufferedReader.readLine();
        while(line != null){
            stringBuilder.append(line);
        }
        inputStream.close();
        return stringBuilder.toString();
    }

    /*
        Parses the string into Person
        Only response 200 is carried forward; rest fails
        Makes Person with all available attributes; checks for all attributes
     */
    // @TODO: Make the 'person' with attributes using setters since one instance

    public Person JSONParsers(String response) throws JSONException{
        JSONObject jsonObject = new JSONObject(response);
        if (jsonObject.getInt("status") == 200){
            if(jsonObject.has("contactInfo")) Contact_JSONParse(jsonObject.getJSONObject("contactInfo"));
            if(jsonObject.has("organizations")) Organizations_JSONParse(jsonObject.getJSONArray("organizations"));
            if(jsonObject.has("demographics")) Demographics_JSONParse(jsonObject.getJSONObject("demographics"));
            if(jsonObject.has("socialProfiles")) SocialProfiles_JSONParse(jsonObject.getJSONArray("socialProfiles"));

        }

        return person;
    }

    /*
       Parses the Json object for Contact
     */
    private void Contact_JSONParse(JSONObject jsonObject) throws JSONException {
        contactinfoPerson.setLast_name(jsonObject.getString("familyName"));
        contactinfoPerson.setFull_name(jsonObject.getString("fullName"));
        contactinfoPerson.setFirst_name(jsonObject.getString("givenName"));

        // JSON parsing for Chats in the contact information
        if (jsonObject.has("chats")) {
            JSONArray json_chats = jsonObject.getJSONArray("chats");
            for (int i = 0; i < json_chats.length(); i++) {
                JSONObject chat_object = json_chats.getJSONObject(i);
                ChatContact chatContact = new ChatContact(chat_object.getString("client"),chat_object.getString("handle"));
                contactinfoPerson.chatContactList.add(chatContact);
            }
        }
        // JSON parsing for Websites in the contact information
        if(jsonObject.has("websites")){
            JSONArray json_websites = jsonObject.getJSONArray("websites");
            for(int i = 0; i < json_websites.length(); i++){
                JSONObject website_object = json_websites.getJSONObject(i);
                WebsiteContact websiteContact = new WebsiteContact(website_object.getString("url"));
                contactinfoPerson.websiteContactList.add(websiteContact);
            }
        }
        person.setContactinfoPerson(contactinfoPerson);
    }

    /*
        Parses the Json object for Organizations
     */
    private void Organizations_JSONParse(JSONArray jsonArray) throws JSONException{
        for(int i = 0; i < jsonArray.length(); i++){
            Organisation_JSONParse(jsonArray.getJSONObject(i));
        }
    }

    /*
        Parses the Json object for Organization
     */
    private void Organisation_JSONParse(JSONObject jsonObject) throws JSONException{
        OrganizationPerson organization = new OrganizationPerson(jsonObject.getString("name"));
        organization.setCurrent_org(jsonObject.getBoolean("current"));
        organization.setPrimary_org(jsonObject.getBoolean("isPrimary"));
        organization.setStDate_org(jsonObject.getString("startDate"));

        if(jsonObject.has("endDate")) organization.setEdDate_org(jsonObject.getString("endDate"));

        person.organizationPersonList.add(organization);
    }

    /*
        Parses the Json object for Demographics
     */
    private void Demographics_JSONParse(JSONObject jsonObject) throws JSONException{
        DemographicPerson demographicPerson = new DemographicPerson();
        demographicPerson.setLocation_person(jsonObject.getString("locationGeneral"));

        if(jsonObject.has("age")) demographicPerson.setAge(jsonObject.getInt("age"));
        if(jsonObject.has("gender")) demographicPerson.setGender_person(jsonObject.getString("gender"));

        person.setDemographicPerson(demographicPerson);
    }

    /*
        Parses the Json array for social and uses helper for one social profile
     */
    private void SocialProfiles_JSONParse(JSONArray jsonArray) throws JSONException{
        for(int i=0; i<jsonArray.length(); i++){
            SocialProfile_JSONParse(jsonArray.getJSONObject(i));
        }
    }

    private void SocialProfile_JSONParse(JSONObject jsonObject) throws JSONException{
        SocialprofilePerson socialprofilePerson = new SocialprofilePerson();

        if(jsonObject.has("bio")) socialprofilePerson.setBio_socialprofile(jsonObject.getString("bio"));
        if(jsonObject.has("followers")) socialprofilePerson.setFollowers_socialprofile(jsonObject.getInt("followers"));
        if(jsonObject.has("following")) socialprofilePerson.setFollowing_socialprofile(jsonObject.getInt("following"));
        if(jsonObject.has("type")) socialprofilePerson.setName_socialprofile(jsonObject.getString("type"));
        if(jsonObject.has("username")) socialprofilePerson.setUsernm_socialprofile(jsonObject.getString("username"));
        if(jsonObject.has("url")) socialprofilePerson.setUrl_socialprofile(jsonObject.getString("url"));

        person.socialprofilePersonList.add(socialprofilePerson);

    }

    
}

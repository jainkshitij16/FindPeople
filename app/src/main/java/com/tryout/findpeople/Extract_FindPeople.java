package com.tryout.findpeople;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Kshitij on 2017-03-16.
 */
public class Extract_FindPeople extends AsyncTask<Void,Void,String> {
    private static final String API_KEY = "&apiKey=86bc2cd8905ee179";
    private static final String API_URL = "https://api.fullcontact.com/v2/person.json?";
    private static final String API_EMAIL_ = "email="; // Look up by email
    private static final String API_PHONE = "phone="; // Look up by phone
    MainActivity_FindPeople findPeople = new MainActivity_FindPeople();
    String user_email = findPeople.editText.toString();
/*
    AsyncTask class requires following methods
    Params; type of parameter sent to the task upon execution
    Progress; type of progress units to perform in the background
    Result; type of the result of the background execution

    *Use Void if one of them don't have any primitive or objects*
 */

    /*
        Parameter matches with Params
        Method states what processes to run in the background
     */
    @Override
    protected String doInBackground(Void... urls) {
        try{
            // Making a call to the API and lookup using email
            URL url = new URL(API_URL+API_EMAIL_+user_email+API_KEY);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            try{
                // Standard process for android for handling https request.
                // Look at Git-hub for improved process
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

    // Converts InputStream to a string for doInBackground
    private String readStream(InputStream inputStream){
        return null;
    }
}

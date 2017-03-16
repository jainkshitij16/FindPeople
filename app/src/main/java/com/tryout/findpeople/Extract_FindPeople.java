package com.tryout.findpeople;

import android.os.AsyncTask;

/**
 * Created by Kshitij on 2017-03-16.
 */
public class Extract_FindPeople extends AsyncTask<Void,Void,String> {
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
    protected String doInBackground(Void... params) {
        return null;
    }
}

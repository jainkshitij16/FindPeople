package com.tryout.findpeople;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity_FindPeople extends AppCompatActivity {

    EditText editText;
    Button button;
    ProgressBar progressBar;
    TextView textView;
    Extract_FindPeople extract_feed; // Reference the class that extracts data using API

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        extract_feed = new Extract_FindPeople();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity__find_people);

        // Each of the attributes of the screen/Activity connected to their respective counterparts
        editText = (EditText) findViewById(R.id.edit_emailtext);
        button = (Button) findViewById(R.id.button_search);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.text_response);

        button.setOnClickListener(new View.OnClickListener() {
            // upon click on search, Extract_FindPeople is called
            @Override
            public void onClick(View v) {
                extract_feed.execute();
            }
        });
    }
}



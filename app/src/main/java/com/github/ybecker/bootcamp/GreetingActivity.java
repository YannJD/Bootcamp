package com.github.ybecker.bootcamp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GreetingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getIntent().getExtras();
        String name = "";
        if (args != null) name = args.getString("name");

        setContentView(R.layout.activity_greeting);

        TextView txt = (TextView) findViewById(R.id.greetingMessage);
        txt.setText("Welcome " + name + " !");
    }
}
package com.github.ybecker.bootcamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void greet(View view) {
        Intent intent = new Intent(this, GreetingActivity.class);
        EditText name = (EditText) findViewById(R.id.mainName);
        intent.putExtra("name", name.getText().toString());
        startActivity(intent);
    }
}
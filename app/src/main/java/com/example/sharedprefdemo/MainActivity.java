package com.example.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.prefs.PreferenceChangeEvent;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create the button and the listener class
        Button button = (Button) findViewById(R.id.btnClick);
//        button.setOnClickListener(new ClickHander());
         //move to anonymous function
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        //Create the shared pref
        // Create a SharedPreferences object
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        // Get an editor for the SharedPreferences object
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Put a string value in the SharedPreferences object
        editor.putString("myString", "Hello, world!");

        // Save the changes to the SharedPreferences object
        editor.apply();



    }

    class ClickHander implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        }
    }
}
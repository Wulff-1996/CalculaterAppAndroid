package com.example.calculaterapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultPageWulff extends AppCompatActivity {

    private static String TAG = "MainActivity";

    private LinearLayout table;
    private ArrayList<String> histories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        Log.d(TAG, "onCreate()");

        init();
    }

    private void init()
    {
        Log.d(TAG, "init()");

        table = findViewById(R.id.tabel);

        histories = getIntent().getStringArrayListExtra("HISTORIES");

        int count = 0;
        for (String history: histories)
        {
            TextView textView = new TextView(this);
            textView.setText(history);
            textView.setTextSize(30);
            textView.setId(count);
            textView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            table.addView(textView);

            TextView textView1 = new TextView(this);
            textView1.setText("--------------------------------------" +
                    "-----------------------------------------------------");
            textView1.setTextSize(10);
            textView1.setId(count);
            textView1.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            table.addView(textView1);
            count++;
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSavedInstance()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }
}

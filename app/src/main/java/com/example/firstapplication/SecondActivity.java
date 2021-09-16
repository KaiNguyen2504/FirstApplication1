package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textViewResult;
    Button butBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        butBack = findViewById(R.id.butBack);
        Intent intent = getIntent();
        String sResult = intent.getStringExtra( "result");
        textViewResult = findViewById(R.id.textViewResult);
        textViewResult.setText(sResult);

        View.OnClickListener listener = (view) -> {finish();};
        butBack.setOnClickListener(listener);
    }
}
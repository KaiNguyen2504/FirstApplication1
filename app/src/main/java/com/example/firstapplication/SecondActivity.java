package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final int RESULT_CODE = 200;
    TextView textReceivedNum1;
    TextView textReceivedNum2;
    TextView textViewResult;
    Button butBack;
    int num1;
    int num2;
    String sResult="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        butBack = findViewById(R.id.butBack);
        textReceivedNum1 = findViewById(R.id.textReceivedNum1);
        textReceivedNum2 = findViewById(R.id.textReceivedNum2);
        textViewResult = findViewById(R.id.textViewResult);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("DATA");
        String sNum1 = bundle.getString("Number1");
        String sNum2 = bundle.getString("Number2");
        textReceivedNum1.setText(sNum1);
        textReceivedNum2.setText(sNum2);

        try{
            num1 = Integer.parseInt(sNum1);
            num2 = Integer.parseInt(sNum2);
            sResult= "" + (num1 + num2);
        }catch (Exception ex){
            sResult="Wrong input number";
        }
        textViewResult.setText(sResult);

        View.OnClickListener listener =(view) -> {
            setResultData();
            finish();
        };
        butBack.setOnClickListener(listener);
    }

    private void setResultData(){
        Intent data = new Intent();
        data.putExtra("ResultData",sResult);
        setResult(RESULT_CODE, data);
    }
}
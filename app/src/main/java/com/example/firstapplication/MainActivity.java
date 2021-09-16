package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextNum1;
    EditText editTextNum2;
    Button buttonOK;
//    String sKQ="";
    String sResult="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNum1 = findViewById(R.id.editTextNum1);
        editTextNum2 = findViewById(R.id.editTextNum2);
        buttonOK = findViewById(R.id.butOK);

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int n1 = Integer.parseInt(editTextNum1.getText().toString());
                    int n2 = Integer.parseInt(editTextNum2.getText().toString());
                    //sKQ= "" + (n1+n2);
                    sResult= "" + (n1+n2);
                }catch (Exception e){
                    sResult="Sai KQ";
                }
                //Toast.makeText(MainActivity.this,sKQ,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("result",sResult);
                startActivity(intent);
            }
        });
    }
}
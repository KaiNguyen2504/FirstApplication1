package com.example.firstapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int REQUEST_CODE = 100;
    EditText editTextNum1;
    EditText editTextNum2;
    Button buttonOK;
    String sResult="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNum1 = findViewById(R.id.editTextNum1);
        editTextNum2 = findViewById(R.id.editTextNum2);
        buttonOK = findViewById(R.id.butOK);

        buttonOK.setOnClickListener((view) -> {
            String sNum1 = editTextNum1.getText().toString();
            String sNum2 = editTextNum2.getText().toString();
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("Number1",sNum1);
            bundle.putString("Number2",sNum2);
            intent.putExtra("DATA",bundle);
            startActivityForResult(intent,REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,requestCode,data);
        if(requestCode == REQUEST_CODE && resultCode == SecondActivity.RESULT_CODE){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Received Result");
            String sResult = data.getStringExtra("ResultData");
            builder.setMessage("The Received Result is: " + sResult);
            builder.setCancelable(false);
            builder.setPositiveButton("OK",(dialogInterface, i) -> {
               dialogInterface.dismiss();
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
}
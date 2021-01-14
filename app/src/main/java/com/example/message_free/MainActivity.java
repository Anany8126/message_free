package com.example.message_free;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextto,editTextcompany,editTextjtype,editTextjd,editTextsal,editTextregards;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS,Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);

        editTextto = findViewById(R.id.et1);
        editTextcompany = findViewById(R.id.et2);
        editTextjtype = findViewById(R.id.et3);
        editTextjd = findViewById(R.id.et4);
        editTextsal = findViewById(R.id.et5);
        editTextregards = findViewById(R.id.et6);

        send = (Button) findViewById(R.id.btn1);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = editTextto.getText().toString().trim();
                String company = "Company Name :- "+editTextcompany.getText().toString().trim();
                String jobtype = "Job Type :- "+editTextjtype.getText().toString().trim();
                String jobdescp ="Job Description :- "+editTextjd.getText().toString().trim();
                String salary = "Package :- "+editTextsal.getText().toString().trim();
                String regards = "Regards :- "+editTextregards.getText().toString().trim();
                String all = company+"\n" +jobtype+"\n" +jobdescp+"\n" +salary+"\n" +regards;



                   if (all.equals("") || all==null){
                       Toast.makeText(MainActivity.this,"Empty",Toast.LENGTH_SHORT).show();}

                   else{
                        if (number.length()==10){
                   SmsManager sm = SmsManager.getDefault();
                    sm.sendTextMessage(number, null,all,null,null );
                    Toast.makeText(MainActivity.this,"Message sent",Toast.LENGTH_SHORT).show();}
                   else {
                   Toast.makeText(MainActivity.this,"Please Fill all Fields",Toast.LENGTH_SHORT).show();}
                   }


            }



        });

    }}

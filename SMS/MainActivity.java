package com.example.lab6;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mobile, smsBody;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobile = findViewById(R.id.mobileNo);
        smsBody = findViewById(R.id.smsBody);
        send = findViewById(R.id.button);
        mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "";
                s = mobile.getText().toString();
                Intent Intent = new Intent(android.content.Intent.ACTION_SENDTO, Uri.parse("sms:" + s));
                startActivity(Intent);
                send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            SmsManager smgr = SmsManager.getDefault();
                            smgr.sendTextMessage(mobile.getText().toString(), null, smsBody.getText().toString(), null, null);
                            Toast.makeText(MainActivity.this, "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            Toast.makeText(MainActivity.this, "SMS Failed to send, Please try again later", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}


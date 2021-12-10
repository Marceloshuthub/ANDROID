package com.example.userdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText uname,pswd;
    Button login,;
    DbHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname= findViewById(R.id.editText);
        pswd=  findViewById(R.id.editText2);
        login= findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=uname.getText().toString();
                String password=pswd.getText().toString();
                int id= checkUser(new User(name,password));
                if(id==-1)
                {
                    Toast.makeText(MainActivity.this,"User Does Not Exist",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Username "+name+ " exist",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(i);
                }
            }
        });
        db=new DbHandler(MainActivity.this);
        db.addUser(new User("marcelo", "12345"));
        db.addUser(new User("harry", "potter"));
        db.addUser(new User("weeknd", "starboy"));
        db.addUser(new User("kanye","west"));
    }
    public int checkUser(User user)
    {
        return db.checkUser(user);
    }
}
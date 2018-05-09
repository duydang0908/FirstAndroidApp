package com.example.duyda.androidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    DatabaseHelper db;

    private EditText username, pass, rePass;
    private Button signUp;
    private TextView goLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        db = new DatabaseHelper(this);

        username = (EditText) findViewById(R.id.etUsername);
        pass = (EditText) findViewById(R.id.etPassword);
        rePass = (EditText) findViewById(R.id.etRePassword);
        signUp = (Button) findViewById(R.id.btnRegistration);
        goLogin = (TextView) findViewById(R.id.tvGoLogin);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = username.getText().toString();
                String s2 = pass.getText().toString();
                String s3 = rePass.getText().toString();
                if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty())
                    Toast.makeText(getApplicationContext(), "Vui long dien day du thong tin", Toast.LENGTH_SHORT).show();
                else if (s2.equals(s3) == false)
                    Toast.makeText(getApplicationContext(), "Mat khau k trung khop", Toast.LENGTH_SHORT).show();
                else {
                    if (s2.equals(s3)) {
                        Boolean checkuser = db.checkUserName(s1);
                        if (checkuser == true) {
                            Boolean insert = db.insert(s1, s2);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Dang ki thanh cong", Toast.LENGTH_SHORT).show();
                            }
                        } else
                            Toast.makeText(getApplicationContext(), "Username da ton tai", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, LoginActivity.class));
            }
        });

    }


}

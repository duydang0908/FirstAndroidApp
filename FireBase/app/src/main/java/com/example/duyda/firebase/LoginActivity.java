package com.example.duyda.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView nofi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        nofi=(TextView)findViewById(R.id.tvNofi);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nofi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });


    }
}

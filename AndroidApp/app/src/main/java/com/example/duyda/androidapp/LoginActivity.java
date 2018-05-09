package com.example.duyda.androidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText name, passWord;
    private Button login;
    private TextView goSignUp;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText) findViewById(R.id.etUsername);
        passWord = (EditText) findViewById(R.id.etPassword);
        login = (Button) findViewById(R.id.btnLogin);
        goSignUp = (TextView) findViewById(R.id.tvGoSignUp);
        db=new DatabaseHelper(this);

//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isValid(name.getText().toString(), passWord.getText().toString());
//            }
//        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() || passWord.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "Dien day du thong tin", Toast.LENGTH_SHORT).show();
                else if(db.checkLogin(name.getText().toString(), passWord.getText().toString()) == true)
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                else
                    Toast.makeText(LoginActivity.this, "Sai thong tin dang nhap!", Toast.LENGTH_SHORT).show();
            }
        });

        goSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, Registration.class));
            }
        });


    }

//    public void isValid(String id, String pass) {
//        if (id.equals("admin") && pass.equals("123")) {
//            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//            startActivity(new Intent(LoginActivity.this, MainActivity.class));
//        } else {
//            Toast.makeText(getApplicationContext(), "Sai tai khoan hoac mat khau", Toast.LENGTH_SHORT).show();
//            count--;
//            if (count == 0) {
//                login.setEnabled(false);
//                Toast.makeText(getApplicationContext(), "Da het so lan dang nhap", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }


}

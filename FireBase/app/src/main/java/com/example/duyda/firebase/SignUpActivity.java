package com.example.duyda.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {


    EditText username, pass, repass;
    TextView nofi;
    Button signup;
    DatabaseReference databaseAccounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        databaseAccounts = FirebaseDatabase.getInstance().getReference("accounts");

        username = (EditText) findViewById(R.id.etUserName);
        pass = (EditText) findViewById(R.id.etPassword);
        repass = (EditText) findViewById(R.id.etRePass);
        nofi = (TextView) findViewById(R.id.tvNofi);
        signup = (Button) findViewById(R.id.btnSignUp);
        nofi.setText("Wanna sign in?");
        nofi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAccount();
            }
        });
    }

    private void addAccount() {
        String name = username.getText().toString();
        String pw = pass.getText().toString();
        String repw = repass.getText().toString();
        if (name.isEmpty() || pw.isEmpty() || repw.isEmpty()) {
            Toast.makeText(getApplication(), "Vui long dien day du thong tin", Toast.LENGTH_SHORT).show();
        } else if (!pw.equals(repw)) {
            Toast.makeText(getApplication(), "Mat khau k trung khop", Toast.LENGTH_SHORT).show();
        } else {
            String id = databaseAccounts.push().getKey();
            UserAccount account = new UserAccount(id, name, pw);
            databaseAccounts.child(id).setValue(account);
            Toast.makeText(getApplication(), "Dang ki thanh cong", Toast.LENGTH_SHORT).show();
        }
    }

}

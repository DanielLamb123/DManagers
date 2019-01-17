package com.example.hoxba.d_managers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textCreateAccount,textFullName,textEmail,textPassword;
    private EditText CAEmail, CAPassword, CAFullName;
    private Button registerButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account_page);
        mAuth = FirebaseAuth.getInstance();
        textCreateAccount = (TextView) findViewById(R.id.textCreateAccount);
        textEmail = (TextView) findViewById(R.id.textEmail);
        textPassword = (TextView) findViewById(R.id.textPassword);
        CAEmail = (EditText) findViewById(R.id.CAEmail);
        CAPassword = (EditText) findViewById(R.id.CAPassword);
//        registerButton=(Button)findViewById(R.id.registerButton);
        findViewById(R.id.registerButton).setOnClickListener(this);
    }
    private void registerUser() {

        String email = CAEmail.getText().toString().trim();
        String password = CAPassword.getText().toString().trim();

        if (email.isEmpty()) {
            CAEmail.setError("Email is required");
            CAEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            CAEmail.setError("Please enter a valid email");
            CAEmail.requestFocus();
            return;
        }
        if (password.length() < 6) {
            CAPassword.setError("Minimum length should be 6");
            CAPassword.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(CreateAccountActivity.this, "User Registered Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    @Override
    public void onClick(View view){
        switch(view.getId()) {
            case R.id.registerButton:
            registerUser();
            break;
        }
    }
}

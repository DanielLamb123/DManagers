package com.example.hoxba.d_managers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView welcomeText,textEmail,textPassword;
    private ImageView imageLogo;
    private EditText enterEmail,enterPassword;
    private Button loginButton,createNewButton;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        welcomeText = (TextView) findViewById(R.id.welcomeText);
        textEmail = (TextView) findViewById(R.id.textEmail);
        textPassword = (TextView) findViewById(R.id.textPassword);
        imageLogo = (ImageView) findViewById(R.id.imageLogo);
        enterEmail = (EditText) findViewById(R.id.enterEmail);
        enterPassword = (EditText) findViewById(R.id.enterPassword);
        loginButton = (Button) findViewById(R.id.loginButton);
        createNewButton = (Button) findViewById(R.id.createNewButton);
        findViewById(R.id.loginButton).setOnClickListener(this);

        mAuth=FirebaseAuth.getInstance();

        createNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CreateAccountActivity.class));

            }
        });
    }
    @Override
    public void onClick(View view){
        switch(view.getId()) {
            case R.id.loginButton:
                userLogin();
                break;
        }
    }

    private void userLogin() {
        final String email = enterEmail.getText().toString().trim();
        String password = enterPassword.getText().toString().trim();

        if (email.isEmpty()) {
            enterEmail.setError("Email is required");
            enterEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            enterEmail.setError("Please enter a valid email");
            enterEmail.requestFocus();
            return;
        }
        if (password.length() < 6) {
            enterPassword.setError("Minimum length should be 6");
            enterPassword.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent i=new Intent(LoginActivity.this,MainActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();


                    
                }else{
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

package com.example.hoxba.d_managers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hoxba.d_managers.Model.Feedback;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackActivity extends AppCompatActivity {
    private EditText editTextName,editTextOccupation,editTextPhone,editTextDescription,editTextAddress;
    private Button buttonSubmit;
    DatabaseReference databaseFeedback;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_page);

        databaseFeedback=FirebaseDatabase.getInstance().getReference("Feedback");

        editTextName=(EditText)findViewById(R.id.editTextName);
        editTextOccupation=(EditText)findViewById(R.id.editTextOccupation);
        editTextPhone=(EditText)findViewById(R.id.editTextPhone);
        editTextDescription=(EditText)findViewById(R.id.editTextDescription);
        editTextAddress=(EditText)findViewById(R.id.editTextAddress);
        buttonSubmit=(Button)findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFeedback();
            }
        }));

    }
    private void addFeedback(){
        String name=editTextName.getText().toString().trim();
        String occupation=editTextOccupation.getText().toString().trim();
        String phone=editTextPhone.getText().toString().trim();
        String description=editTextDescription.getText().toString().trim();
        String address=editTextAddress.getText().toString().trim();

        if(!TextUtils.isEmpty(name)){
            String id=databaseFeedback.push().getKey();
            Feedback feedback=new Feedback(id,name,occupation,phone,description,address);
            databaseFeedback.child(id).setValue(feedback);
            Toast.makeText(this,"Feedback added",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Field is empty",Toast.LENGTH_LONG).show();
        }
    }




}

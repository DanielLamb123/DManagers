package com.example.hoxba.d_managers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ThankYouActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thank_you_page);
        ImageButton backHomeButton = (ImageButton) findViewById(R.id.backhomeButton);
        backHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ThankYouActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

}

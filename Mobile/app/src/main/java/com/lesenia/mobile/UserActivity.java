package com.lesenia.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        auth = FirebaseAuth.getInstance();
        Button logOutButton = findViewById(R.id.user_logoutButton);
        TextView name = findViewById(R.id.user_name);
        final FirebaseUser user = auth.getCurrentUser();

        if (user != null) {
            name.setText(user.getDisplayName());
        } else {
            error();
        }

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                startActivity(new Intent(UserActivity.this, RegisterActivity.class));
            }
        });
    }

    private void error(){
        Toast.makeText(UserActivity.this, getString(R.string.error), Toast.LENGTH_LONG).show();
    }
}

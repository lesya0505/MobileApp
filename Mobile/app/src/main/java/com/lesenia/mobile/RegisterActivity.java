package com.lesenia.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private Button registerButton;
    private TextView loginLink;
    private TextInputEditText emailField;
    private TextInputEditText passwordField;
    private TextInputEditText usernameField;
    private TextInputEditText phoneField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = Objects.requireNonNull(usernameField.getText()).toString().trim();
                final String phone = Objects.requireNonNull(phoneField.getText()).toString().trim();
                final String email = Objects.requireNonNull(emailField.getText()).toString().trim();
                final String password = Objects.requireNonNull(passwordField.getText()).toString().trim();
                Register(email, password, username, phone);
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }

    private void initViews() {
        emailField = findViewById(R.id.register_email);
        passwordField = findViewById(R.id.register_password);
        usernameField = findViewById(R.id.register_username);
        phoneField = findViewById(R.id.register_phone);
        auth = auth = getRetrofitEx().getAuth();
        registerButton = findViewById(R.id.registerButton);
        loginLink = findViewById(R.id.register_loginLink);
    }

    private void Register(final String email, final String password, final String username, final String phone) {
        if (isDataValid(username, phone, email, password)) {
            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, getString(R.string.email_taken),
                                        Toast.LENGTH_LONG).show();
                            } else {
                                onCompleteSuccess(username);
                            }
                        }
                    });
        }
    }

    private void onCompleteSuccess(final String username) {
        FirebaseUser user = auth.getCurrentUser();
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(username).build();

        if (user != null) {
            user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        RegisterActivity.this
                                .startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    }
                }
            });
        }
    }

    private boolean isUsernameValid(final String username) {
        if (username.isEmpty()) {
            usernameField.setError(getString(R.string.enter_username));
            return false;
        } else {
            usernameField.setError(null);
            return true;
        }
    }

    private boolean isPhoneValid(final String phone) {
        if (phone.isEmpty() || (!phone.matches("^[0-9]$") && phone.length() < 10)) {
            phoneField.setError(getString(R.string.enter_valid_phone));
            return false;
        } else {
            phoneField.setError(null);
            return true;
        }
    }

    private boolean isEmailValid(final String email) {
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailField.setError(getString(R.string.enter_valid_email));
            return false;
        } else {
            emailField.setError(null);
            return true;
        }
    }

    private boolean isPasswordValid(final String password) {
        if (password.isEmpty() || password.length() < 8) {
            passwordField.setError(getString(R.string.password_limit));
            return false;
        } else {
            passwordField.setError(null);
            return true;
        }
    }

    private boolean isDataValid(final String username, final String phone, final String email, final String password) {
        return isUsernameValid(username) && isPhoneValid(phone) && isEmailValid(email) && isPasswordValid(password);
    }

    private RetrofitEx getRetrofitEx() {
        return ((RetrofitEx) getApplication());
    }
}
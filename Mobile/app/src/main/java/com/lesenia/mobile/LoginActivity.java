package com.lesenia.mobile;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private Button loginButton;
    private TextView signUpLink;
    private TextInputEditText emailField;
    private TextInputEditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = Objects.requireNonNull(Objects.requireNonNull(emailField.getText()).toString().trim());
                final String password = Objects.requireNonNull(passwordField.getText()).toString().trim();
                logIn(email, password);
            }
        });
        signUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    private void initViews() {
        auth = getRetrofitEx().getAuth();
        emailField = findViewById(R.id.login_email);
        passwordField = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_loginButton);
        signUpLink = findViewById(R.id.login_signUpLink);
    }

    private void logIn(final String email, final String password) {

        if (isDataValid(email, password)) {
            Task<AuthResult> authResultTask = auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            } else {
                                loginError();
                            }
                        }
                    });
        }
    }

    private boolean isEmailValid(final String email) {
        if (email.isEmpty()) {
            emailField.setError(getString(R.string.enter_email));
            return false;
        } else {
            emailField.setError(null);
            return true;
        }
    }

    private boolean isPasswordValid(final String password) {
        if (password.isEmpty() || password.length() < 8) {
            passwordField.setError(getString(R.string.invalid_password));
            return false;
        } else {
            passwordField.setError(null);
            return true;
        }
    }

    private boolean isDataValid(final String email, final String password) {
        return isEmailValid(email) && isPasswordValid(password);
    }

    private void loginError() {
        Toast.makeText(LoginActivity.this, getString(R.string.login_error), Toast.LENGTH_LONG).show();
    }

    private RetrofitEx getRetrofitEx() {
        return ((RetrofitEx) getApplication());
    }
}
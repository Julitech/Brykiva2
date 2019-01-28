package com.julitech.brykiva;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText emailEditText;
    TextInputEditText pwdEditText;
    FirebaseAuth mAuth;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        preferences = getSharedPreferences("com.julitech.brykiva", MODE_PRIVATE);
        emailEditText = (TextInputEditText) findViewById(R.id.loginEmail);
        pwdEditText = (TextInputEditText) findViewById(R.id.loginPwd);

    }

    public void signIn(View view) {


        String email = emailEditText.getText().toString();
        String password = pwdEditText.getText().toString();


        if (!email.isEmpty()) {
            if (!password.isEmpty()) {
                final AlertDialog dialog = new AlertDialog.Builder(this)
                        .setView(R.layout.loading_dialog)
                        .setCancelable(false)
                        .show();

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    //Log in successful

                                    preferences.edit()
                                            .putBoolean("SignIn", true)
                                            .apply();
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);

                                } else {
                                    dialog.dismiss();

                                    String error = ((FirebaseAuthException) task.getException()).getErrorCode();
                                    switch (error){
                                        case "ERROR_WRONG_PASSWORD":
                                            pwdEditText.setError("Wrong password");
                                            pwdEditText.requestFocus();
                                            break;
                                        default:
                                            Toast.makeText(LoginActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                            break;

                                    }
                                }
                            }
                        });
            } else {
                pwdEditText.setError("Please input password");
            }
        } else {
            //Email input error message
            emailEditText.setError("Please enter your email address");
        }


    }

    //Open signup activity
    public void openSignUp(View view) {


        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}

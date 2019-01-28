package com.julitech.brykiva;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignUpActivity extends AppCompatActivity {

    TextInputEditText nameEditText;
    TextInputEditText emailEditText;
    TextInputEditText pwdEditText;
    private FirebaseAuth mAuth;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        preferences = getSharedPreferences("com.julitech.brykiva",MODE_PRIVATE);

        nameEditText = (TextInputEditText) findViewById(R.id.nameEditText);
        emailEditText = (TextInputEditText) findViewById(R.id.emailEditText);
        pwdEditText = (TextInputEditText) findViewById(R.id.pwdEditText);

    }

    public void signUp(View view){

        final String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = pwdEditText.getText().toString();



        if (!name.isEmpty()){
            if (!email.isEmpty()){
                if (!password.isEmpty()){
                    if (password.length() >= 6){
                        final AlertDialog dialog = new AlertDialog.Builder(this)
                                .setView(R.layout.loading_dialog)
                                .setCancelable(false)
                                .show();

                        mAuth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            // Sign in success, update UI with the signed-in user's information
                                            Log.d("TAG", "createUserWithEmail:success");
                                            FirebaseUser user = mAuth.getCurrentUser();
                                            user.updateProfile(new UserProfileChangeRequest.Builder()
                                                    .setDisplayName(name)
                                                    .build()
                                            );

                                            //Save details on shared preferences
                                            preferences.edit()
                                                    .putBoolean("SignIn",true)
                                                    .putString("AccountName",name)
                                                    .apply();

                                            //Start main activity
                                            Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                                            startActivity(intent);
                                        } else {
                                            // If sign in fails, display a message to the user.

                                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                                            dialog.dismiss();
                                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                                    Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                });
                    }else {
                        pwdEditText.setError("Password must be at least 6 characters");
                    }
                }else {
                    // Password input error message
                    pwdEditText.setError("Please input password");
                }
            }else {
                //Email input error message
                emailEditText.setError("Please enter your email address");
            }
        }else {
            //Name input error message
            nameEditText.setError("Please enter your name");
        }


    }

    public void openLogIn(View view) {


        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}

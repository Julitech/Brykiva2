package com.julitech.brykiva;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MeActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser user;
    SharedPreferences preferences;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                finish();
                return true;
            case R.id.mEditProfile :
                Intent intent = new Intent(this,EditProfileActivity.class);
                startActivity(intent);
                return true;
            case R.id.mSignOut:
                //Sign out
                new AlertDialog.Builder(this)
                        .setTitle("Sign Out")
                        .setMessage("Are you sure you want to sign out?")
                        .setNegativeButton("No",null)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                preferences.edit()
                                        .putBoolean("SignIn",false)
                                        .apply();
                                mAuth.signOut();
                                finish();
                                Intent intent = new Intent(MeActivity.this,WizardActivity.class);
                                startActivity(intent);
                            }
                        })
                        .show();

                return true;
            default:
                return false;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        preferences = getSharedPreferences("com.julitech.brykiva",MODE_PRIVATE);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        String name = user.getDisplayName();
        TextView profileName = (TextView) findViewById(R.id.profileName);
        profileName.setText(name);
    }
}

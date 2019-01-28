package com.julitech.brykiva;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EditProfileActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
    TextInputEditText editTextName;
    TextInputEditText editTextemail;
    private static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);


        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        String oldName = user.getDisplayName();
        String oldEmail = user.getEmail();

        editTextName = (TextInputEditText) findViewById(R.id.editName);
        editTextemail = (TextInputEditText) findViewById(R.id.editEmail);

        editTextName.setText(oldName);
        editTextemail.setText(oldEmail);


    }

    //Change Image button click
    public void changeImage(View view){

        //Intent to choose image
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent,"Select Picture"),PICK_IMAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE){


        }


    }

    //save profile changes
    public void saveProfile(View view) {

    }

}

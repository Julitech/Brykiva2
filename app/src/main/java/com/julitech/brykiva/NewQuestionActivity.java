package com.julitech.brykiva;

import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.julitech.brykiva.helpers.Tools;
import com.julitech.brykiva.models.Questions;

public class NewQuestionActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseAuth auth;
    FirebaseUser user;

    String userName;
    String userId;
    EditText question;
    EditText qDescription;
    ActionBar actionBar;


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_question);

        actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("New Question");

        auth = FirebaseAuth.getInstance();
        userId = auth.getCurrentUser().getUid();
        userName = auth.getCurrentUser().getDisplayName();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();

        question = (EditText) findViewById(R.id.qTitleEditText);
        qDescription = (EditText) findViewById(R.id.qDescEditText);


    }

    public void postQuestion(View view){

        boolean internet = new Tools().isNetworkConnected(getApplicationContext());
        if (internet){
            //Add new question to firebase

            String questionTitle = question.getText().toString();
            String questionDesc = qDescription.getText().toString();

            Questions questions = new Questions(userId,userName,questionTitle,questionDesc,ServerValue.TIMESTAMP,0);

            reference.child("Questions")
                    .push().setValue(questions,ServerValue.TIMESTAMP)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){

                                Toast.makeText(NewQuestionActivity.this,"Question Posted Successfully",Toast.LENGTH_SHORT).show();
                                finish();
                            }else {
                                Toast.makeText(NewQuestionActivity.this,"Failed",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }else {
            Toast.makeText(this,"No Internet!",Toast.LENGTH_SHORT).show();
        }


    }
}

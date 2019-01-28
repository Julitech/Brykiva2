package com.julitech.brykiva;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;
import com.julitech.brykiva.helpers.Tools;
import com.julitech.brykiva.models.Answers;
import com.julitech.brykiva.models.Questions;

public class QuestionActivity extends AppCompatActivity {


    ActionBar actionBar;
    TextView qTitle;
    TextView questionText;
    TextView name;
    TextView dateText;
    EditText answerEditText;
    ImageButton sendBtn;
    ListView listView;
    int answersCount;

    String question_key;


    //Firebase variables
    FirebaseListAdapter<Questions> listAdapter;
    FirebaseDatabase database;
    DatabaseReference questionRef;
    DatabaseReference answerRef;
    FirebaseAuth auth;
    FirebaseUser user;
    String userName;


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
        setContentView(R.layout.activity_question);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Q&A Discussions");


        //Get question key from intent
        question_key = getIntent().getStringExtra("key");

        //Initialising firebase variables

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        userName = user.getDisplayName();
        database = FirebaseDatabase.getInstance();
        questionRef = database.getReference().child("Questions").child(question_key);
        answerRef = database.getReference().child("Answers").child(question_key);


        qTitle = (TextView) findViewById(R.id.qTitle);
        questionText = (TextView) findViewById(R.id.qText);
        answerEditText = (EditText) findViewById(R.id.ansEditText);
        name = (TextView) findViewById(R.id.qName);
        dateText = (TextView) findViewById(R.id.date);
        sendBtn = (ImageButton) findViewById(R.id.sendAnsBtn);
        sendBtn.setEnabled(false);

        //Enable sendbtn whe there's text to send
        answerEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.toString().trim().length() > 0){
                        sendBtn.setEnabled(true);
                    }else {
                        sendBtn.setEnabled(false);
                    }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        listView = (ListView) findViewById(R.id.answersList);


        //Get question data from firebase
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Questions question =  dataSnapshot.getValue(Questions.class);
                qTitle.setText(question.getTitle());
                questionText.setText(question.getQuestion());
                name.setText(question.getUserName());

                answersCount = question.getAnswers();


                long timeStamp = question.getTime();
                String fDate = new Tools().getFormattedDate(timeStamp);
                dateText.setText(fDate);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        questionRef.addValueEventListener(listener);


        FirebaseListAdapter<Answers> listAdapter = new FirebaseListAdapter<Answers>(this,Answers.class,R.layout.item_answers,answerRef) {
            @Override
            protected void populateView(View view, Answers answers, int i) {
                ((TextView)view.findViewById(R.id.answer)).setText(answers.getAnswer());

                TextView user = view.findViewById(R.id.user);
                TextView date = view.findViewById(R.id.timeText);
                user.setText(answers.getUserName());
                String fDate = new Tools().getFormattedDate(answers.getTime());
                date.setText(fDate);

            }
        };

        listView.setAdapter(listAdapter);

    }



    //Send answer method
    public void sendAnswer(View view){
        String answer = answerEditText.getText().toString();


        //Add 1 to answer counter in question
        questionRef.child("answers").setValue(++answersCount);
        //Set answer in answers child
        Answers answers = new Answers(answer,userName, ServerValue.TIMESTAMP);
        answerRef.push().setValue(answers);

        //Clear edittext
        answerEditText.setText("");
    }

}

package com.julitech.brykiva.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

//import com.firebase.ui.database.FirebaseListAdapter;
//import com.firebase.ui.database.FirebaseListOptions;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.julitech.brykiva.NewQuestionActivity;
import com.julitech.brykiva.QuestionActivity;
import com.julitech.brykiva.R;
import com.julitech.brykiva.helpers.Tools;
import com.julitech.brykiva.models.Questions;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionsFragment extends Fragment {

    LinearLayout internetError;
    ListView listView;

    //Initialize Firebase variables
    FirebaseListAdapter<Questions> listAdapter;
    FirebaseDatabase database;
    DatabaseReference myRef;

    public QuestionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_questions, container, false);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NewQuestionActivity.class);
                startActivity(intent);
            }
        });

        internetError = view.findViewById(R.id.internetError);
        listView = view.findViewById(R.id.questionsListView);

        boolean isInternetAvailable = new Tools().isNetworkConnected(getActivity().getApplicationContext());
        if (isInternetAvailable){
            internetError.setVisibility(View.INVISIBLE);
            loadQuestions();
        }else {
            internetError.setVisibility(View.VISIBLE);
        }





        return view;
    }

    private void loadQuestions(){
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("Questions");
        myRef.keepSynced(true);

        listAdapter = new FirebaseListAdapter<Questions>(getActivity(), Questions.class, R.layout.item_questions, myRef) {
            @Override
            protected void populateView(View listView, Questions questions, final int i) {
                //Populate listview
                ((TextView)listView.findViewById(R.id.question_text)).setText(questions.getTitle());

//                ((TextView)listView.findViewById(R.id.)).setText((Long.toString(questions.getTime())));

                TextView answerCount = listView.findViewById(R.id.answers_count);
                answerCount.setText(Integer.toString(questions.getAnswers()));

                TextView date = listView.findViewById(R.id.question_time);
                String fDate = new Tools().getFormattedDate(questions.getTime());
                date.setText(fDate);

                listView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String key = listAdapter.getRef(i).getKey();
                        Intent intent = new Intent(getActivity().getApplicationContext(), QuestionActivity.class);
                        intent.putExtra("key",key);
                        startActivity(intent);
                    }
                });

            }
        };
        listView.setAdapter(listAdapter);
    }
}

package com.julitech.brykiva.courses;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import com.julitech.brykiva.R;
import com.julitech.brykiva.courses.css.cLesson1Fragment;
import com.julitech.brykiva.courses.css.cLesson2Fragment;
import com.julitech.brykiva.courses.css.cLesson3Fragment;
import com.julitech.brykiva.courses.css.cLesson4Fragment;
import com.julitech.brykiva.courses.css.cLesson5Fragment;
import com.julitech.brykiva.courses.css.cLesson6Fragment;
import com.julitech.brykiva.courses.css.cLesson7Fragment;

public class CssLessonActivity extends AppCompatActivity {


    FrameLayout frameLayout;
    ActionBar actionBar;
    Button continueBtn;
    FragmentTransaction transaction;
    ScrollView scrollView;
    int lessonId;

    String[] topics = {
            "CSS Basics",
            "CSS Syntax",
            "CSS Selectors",
            "CSS Inheritance",
            "CSS Priority",
            "CSS Color Units",
            "CSS Size Units",
            "CSS Reset"
    };

    Fragment[] lessonFragments = {
            new cLesson1Fragment(),
            new cLesson2Fragment(),
            new cLesson3Fragment(),
            new cLesson4Fragment(),
            new cLesson5Fragment(),
            new cLesson6Fragment(),
            new cLesson7Fragment()

    };


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                finish();
                return true;
            default:
                return false;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_css_lesson);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        scrollView = (ScrollView) findViewById(R.id.scrollView);



        //Get lesson id
        lessonId = getIntent().getIntExtra("lesson",0);

        actionBar.setTitle(topics[lessonId-1]);

        frameLayout = (FrameLayout) findViewById(R.id.lessonContainer);
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.lessonContainer,lessonFragments[lessonId-1]);
        transaction.commit();

        continueBtn = (Button) findViewById(R.id.continueBtn);
        if (lessonId == topics.length){
            continueBtn.setVisibility(View.INVISIBLE);
        }else {
            continueBtn.setVisibility(View.VISIBLE);
        }

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.fullScroll(View.FOCUS_UP);
                actionBar.setTitle(topics[lessonId]);
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.lessonContainer,lessonFragments[lessonId]);
                transaction1.commit();
                lessonId++;
            }
        });

    }
}

package com.julitech.brykiva.courses;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ScrollingView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import com.julitech.brykiva.R;
import com.julitech.brykiva.courses.html.hLesson10Fragment;
import com.julitech.brykiva.courses.html.hLesson11Fragment;
import com.julitech.brykiva.courses.html.hLesson1Fragment;
import com.julitech.brykiva.courses.html.hLesson2Fragment;
import com.julitech.brykiva.courses.html.hLesson3Fragment;
import com.julitech.brykiva.courses.html.hLesson4Fragment;
import com.julitech.brykiva.courses.html.hLesson5Fragment;
import com.julitech.brykiva.courses.html.hLesson6Fragment;
import com.julitech.brykiva.courses.html.hLesson7Fragment;
import com.julitech.brykiva.courses.html.hLesson8Fragment;
import com.julitech.brykiva.courses.html.hLesson9Fragment;

public class LessonActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    ActionBar actionBar;
    Button continueBtn;
    FragmentTransaction transaction;
    ScrollView scrollView;
    int lessonId;


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


    String[] lessonTitles = {
            "HTML Basics",
            "HTML Elements",
            "HTML Hierarchy",
            "HTML Semantics",
            "HTML Formatting",
            "HTML Text",
            "Inline Semantics",
            "HTML Links",
            "HTML Images",
            "HTML Tables",
            "HTML Structure"
    };
    Fragment[] lessonFragments = {
            new hLesson1Fragment(),
            new hLesson2Fragment(),
            new hLesson3Fragment(),
            new hLesson4Fragment(),
            new hLesson5Fragment(),
            new hLesson6Fragment(),
            new hLesson7Fragment(),
            new hLesson8Fragment(),
            new hLesson9Fragment(),
            new hLesson10Fragment(),
            new hLesson11Fragment()
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        scrollView = (ScrollView) findViewById(R.id.lessonScrollView);



        //Get lesson id
        lessonId = getIntent().getIntExtra("lesson",0);

        actionBar.setTitle(lessonTitles[lessonId-1]);

        frameLayout = (FrameLayout) findViewById(R.id.lessonContainer);
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.lessonContainer,lessonFragments[lessonId-1]);
        transaction.commit();


        continueBtn = (Button) findViewById(R.id.continueBtn);
        if (lessonId == lessonTitles.length){
            continueBtn.setVisibility(View.INVISIBLE);
        }else {
            continueBtn.setVisibility(View.VISIBLE);
        }
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.fullScroll(View.FOCUS_UP);
                actionBar.setTitle(lessonTitles[lessonId]);
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.lessonContainer,lessonFragments[lessonId]);
                transaction1.commit();
                lessonId++;

                if (lessonId == lessonTitles.length){
                    continueBtn.setVisibility(View.INVISIBLE);
                }else {
                    continueBtn.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}

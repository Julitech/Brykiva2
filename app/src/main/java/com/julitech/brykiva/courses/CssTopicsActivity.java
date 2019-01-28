package com.julitech.brykiva.courses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.julitech.brykiva.R;
import com.julitech.brykiva.adapters.TopicsAdapter;

public class CssTopicsActivity extends AppCompatActivity {

    ListView topicsList;
    TopicsAdapter topicsAdapter;
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
        setContentView(R.layout.activity_css_topics);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("CSS Tutorial");

        topicsAdapter = new TopicsAdapter(this.getApplicationContext(),topics);
        topicsList = (ListView) findViewById(R.id.cssTopicsList);
        topicsList.setAdapter(topicsAdapter);

        topicsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CssTopicsActivity.this,CssLessonActivity.class);
                intent.putExtra("lesson",position+1);
                startActivity(intent);
            }
        });

    }
}

package com.julitech.brykiva.courses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.julitech.brykiva.R;
import com.julitech.brykiva.adapters.TopicsAdapter;

public class HtmlTopicsActivity extends AppCompatActivity {


    ListView listView;
    String[] topics = {
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
        setContentView(R.layout.activity_html_topics);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("HTML Tutorial");


        listView = (ListView) findViewById(R.id.htmlTopicsList);
        TopicsAdapter adapter = new TopicsAdapter(this,topics);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HtmlTopicsActivity.this,LessonActivity.class);
                intent.putExtra("lesson",position+1);
                startActivity(intent);
            }
        });
    }

}

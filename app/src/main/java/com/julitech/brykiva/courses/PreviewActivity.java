package com.julitech.brykiva.courses;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.julitech.brykiva.R;
import com.julitech.brykiva.adapters.SectionPagerAdapter;
import com.julitech.brykiva.fragments.CssDescriptionFragment;
import com.julitech.brykiva.fragments.CssIndexFragment;
import com.julitech.brykiva.fragments.DescriptionFragment;
import com.julitech.brykiva.fragments.IndexFragment;
import com.julitech.brykiva.helpers.DBHelper;

import java.util.Calendar;

public class PreviewActivity extends AppCompatActivity {


    SectionPagerAdapter adapter;
    ViewPager pager;
    String selectedCourse;
    Button enrollBtn;
    int courseId;
    boolean courseEnrolled;


    public int getCourseId() {
        return courseId;
    }

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
        setContentView(R.layout.activity_preview);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        enrollBtn = (Button) findViewById(R.id.enrollBtn);

        selectedCourse = getIntent().getStringExtra("course");

        switch (selectedCourse){
            case "HTML":
                getSupportActionBar().setTitle("HTML");
                courseId = 1;
                break;
            case "CSS":
                getSupportActionBar().setTitle("CSS");
                courseId = 2;
                break;
            case "Javascript":
                getSupportActionBar().setTitle("Javascript");
                courseId = 3;
                break;
        }

        DBHelper dbHelper = new DBHelper(PreviewActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("COURSES",new String[]{"_id","COURSE"},"COURSEID =?",new String[]{Integer.toString(courseId)},null,null,null);
        courseEnrolled = cursor.moveToFirst();
        cursor.close();
        db.close();


        if (courseEnrolled){
            enrollBtn.setText("Start Learning");
        }else {
            enrollBtn.setText("Enroll Now");
        }

        pager = (ViewPager) findViewById(R.id.sectionPager);
        adapter = new SectionPagerAdapter(getSupportFragmentManager());
        if (courseId == 1){
            adapter.addFragment(new DescriptionFragment(),"Description");
            adapter.addFragment(new IndexFragment(),"Topics");
        }else {
            adapter.addFragment(new CssDescriptionFragment(),"Description");
            adapter.addFragment(new CssIndexFragment(),"Topics");
        }

        pager.setAdapter(adapter);
        TabLayout layout = (TabLayout) findViewById(R.id.tab_layout);
        layout.setupWithViewPager(pager);


    }

    public void enrollNow(final View view){
        if (courseEnrolled){
            switch (courseId){
                case 1:
                    Intent intent = new Intent(this, HtmlTopicsActivity.class);
                    startActivity(intent);
                    break;
                case 2:
                    Intent cssIntent = new Intent(this, CssTopicsActivity.class);
                    startActivity(cssIntent);
                    break;
            }
        }else {
            new AlertDialog.Builder(this)
                    .setTitle("Confirm")
                    .setMessage("Are you sure you want to enroll for this course?")
                    .setNegativeButton("No",null)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DBHelper dbHelper = new DBHelper(PreviewActivity.this);
                            SQLiteDatabase db = dbHelper.getWritableDatabase();
                            ContentValues values = new ContentValues();
                            switch (selectedCourse){
                                case "HTML":
                                    values.put("COURSE","HTML");
                                    values.put("COURSEID",1);
                                    values.put("DATE", Calendar.getInstance().getTimeInMillis());
                                    values.put("PROGRESS",0);
                                    db.insert("COURSES",null,values);
                                    db.close();
                                    break;
                                case "CSS":
                                    values.put("COURSE","CSS");
                                    values.put("COURSEID",2);
                                    values.put("DATE", Calendar.getInstance().getTimeInMillis());
                                    values.put("PROGRESS",0);
                                    db.insert("COURSES",null,values);
                                    db.close();
                                    break;
                                case "Javascript":
                                    values.put("COURSE","Javascript");
                                    values.put("COURSEID",3);
                                    values.put("DATE", Calendar.getInstance().getTimeInMillis());
                                    values.put("PROGRESS",0);
                                    db.insert("COURSES",null,values);
                                    db.close();
                                    break;
                            }
                            courseEnrolled = true;
                            enrollBtn.setText("Start Learning");
                        }
                    })
                    .show();
        }

    }

}

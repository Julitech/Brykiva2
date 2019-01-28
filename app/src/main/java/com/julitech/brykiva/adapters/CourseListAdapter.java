package com.julitech.brykiva.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.julitech.brykiva.R;

/**
 * Created by HP on 03-Jan-2019.
 */
public class CourseListAdapter extends BaseAdapter {

    Cursor cursor;
    LayoutInflater layoutInflater;
    Context context;

    public CourseListAdapter(Cursor cursor, Context context) {
        this.cursor = cursor;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return cursor.getCount();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        cursor.moveToPosition(position);
        return cursor.getInt(2);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = layoutInflater.inflate(R.layout.item_course,null);

        cursor.moveToPosition(position);
        ImageView image = view.findViewById(R.id.courseImage);
        TextView courseTitle = view.findViewById(R.id.courseName);
        TextView progressTextView = view.findViewById(R.id.progress);

        String title = cursor.getString(1);
        String progress = cursor.getString(3);

        switch (title){
            case "HTML":
                image.setImageResource(R.drawable.course_html);
                break;
            case "CSS":
                image.setImageResource(R.drawable.course_css);
                break;
            case "Javascript":
                image.setImageResource(R.drawable.course_js);
        }

        courseTitle.setText(title);
        progressTextView.setText(progress + "% Completed");

        return view;
    }
}

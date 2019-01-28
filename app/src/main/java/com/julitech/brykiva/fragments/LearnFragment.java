package com.julitech.brykiva.fragments;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.julitech.brykiva.R;
import com.julitech.brykiva.adapters.CourseListAdapter;
import com.julitech.brykiva.courses.CssTopicsActivity;
import com.julitech.brykiva.courses.HtmlTopicsActivity;
import com.julitech.brykiva.helpers.DBHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class LearnFragment extends Fragment {

    CourseListAdapter listAdapter;
    Cursor cursor;


    public LearnFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_learn, container, false);
        try {

            DBHelper helper = new DBHelper(getActivity().getApplicationContext());
            SQLiteDatabase db = helper.getWritableDatabase();
            cursor = db.query("COURSES",new String[]{"_id ","COURSE ","COURSEID","PROGRESS "},null,null,null,null,null);
            listAdapter = new CourseListAdapter(cursor,getActivity().getApplicationContext());


        }catch (Exception e){
            Toast.makeText(getActivity().getApplicationContext(),"Database error",Toast.LENGTH_SHORT).show();

        }


        ListView courseList = view.findViewById(R.id.courseList);
        courseList.setAdapter(listAdapter);
        courseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //open course activity based on id
                switch ((int) id){
                    case 1:
                        Intent intent = new Intent(getActivity().getApplicationContext(), HtmlTopicsActivity.class);
                        intent.putExtra("CourseId",id);
                        startActivity(intent);
                        break;
                    case 2:
                        Intent cssIntent = new Intent(getActivity().getApplicationContext(), CssTopicsActivity.class);
                        startActivity(cssIntent);
                        break;
                }

            }
        });



//        CardView cardView = view.findViewById(R.id.cardJava);
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (cursor!=null){

            try {

                DBHelper helper = new DBHelper(getActivity().getApplicationContext());
                SQLiteDatabase db = helper.getWritableDatabase();
                cursor = db.query("COURSES",new String[]{"_id ","COURSE ","COURSEID","PROGRESS "},null,null,null,null,null);
                listAdapter.notifyDataSetChanged();


            }catch (Exception e){
                Toast.makeText(getActivity().getApplicationContext(),"Database error",Toast.LENGTH_SHORT).show();

            }
        }
    }
}

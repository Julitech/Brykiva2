package com.julitech.brykiva.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.julitech.brykiva.R;

/**
 * Created by HP on 31-Dec-2018.
 */
public class QuestionsAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;


    String[] questions = {"what is happening","What is the best editor for html and ssscss"};


    public QuestionsAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = inflater.inflate(R.layout.item_questions,null);

        ImageView user = view.findViewById(R.id.user_img);

        return view;
    }
}

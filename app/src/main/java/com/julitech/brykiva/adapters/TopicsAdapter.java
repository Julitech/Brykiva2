package com.julitech.brykiva.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.julitech.brykiva.R;

/**
 * Created by HP on 12-Jan-2019.
 */
public class TopicsAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;


    String[] topics;



    public TopicsAdapter(Context context,String[] topics) {
        this.context = context;
        this.topics = topics;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return topics.length;
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
        view = inflater.inflate(R.layout.item_topic,null);

        TextView title = view.findViewById(R.id.topicTitle);
        int i = position+1;
        title.setText(i + ". " + topics[position]);

        return view;
    }
}

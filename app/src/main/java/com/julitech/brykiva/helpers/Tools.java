package com.julitech.brykiva.helpers;

import android.content.Context;
import android.net.ConnectivityManager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {


    public String  getFormattedDate(long dateInMillisecods){

        Date date = new Date(dateInMillisecods);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
        return format.format(date);

    }


    //get network state
    public boolean isNetworkConnected(Context context){

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;

    }


}

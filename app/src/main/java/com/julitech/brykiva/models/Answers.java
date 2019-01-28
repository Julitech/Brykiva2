package com.julitech.brykiva.models;

import com.google.firebase.database.Exclude;

public class Answers {

    String answer;
    String userName;
    Object timeStamp;

    public Answers() {
        //Required by firebase
    }
    public Answers(String answer,String userName,Object timeStamp){
        this.answer = answer;
        this.userName = userName;
        this.timeStamp = timeStamp;
    }
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Object getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Object timeStamp) {
        this.timeStamp = timeStamp;
    }
    @Exclude
    public long getTime(){
        return (long)getTimeStamp();
    }

}

package com.julitech.brykiva.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.ServerValue;

import java.util.HashMap;
import java.util.Map;

public class Questions {

    String uid;
    String userName;
    String title;
    String question;
    Object timeStamp = ServerValue.TIMESTAMP;
    int answers;

    public Questions() {
    }

    public Questions(String uid, String userName, String title, String question, Object timeStamp, int answers) {
        this.uid = uid;
        this.userName = userName;
        this.title = title;
        this.question = question;
        this.timeStamp = timeStamp;
        this.answers = answers;
    }

    public String getTitle() {
        return title;
    }

    public String getQuestion() {
        return question;
    }

    public String getUid() {
        return uid;
    }

    public String getUserName() {
        return userName;
    }


    public Object getTimeStamp() {
        return timeStamp;
    }

    public int getAnswers() {
        return answers;
    }

    public void setAnswers(int answers) {
        this.answers = answers;
    }

    public void setTimeStamp(Object timeStamp) {
        this.timeStamp = timeStamp;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Exclude
    public long getTime() {
        return (long) getTimeStamp();
    }
}

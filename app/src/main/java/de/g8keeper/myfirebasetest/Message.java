package de.g8keeper.myfirebasetest;

import android.support.annotation.NonNull;

public class Message {

    private int id;
    private String user;
    private String alter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Message(){

    }

    public Message(int id, String user, String alter) {
        this.id = id;
        this.user = user;
        this.alter = alter;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAlter() {
        return alter;
    }

    public void setAlter(String alter) {
        this.alter = alter;
    }

    @NonNull
    @Override
    public String toString() {
        return this.id + " (" + this.user + ", " + this.alter + ")";
    }
}

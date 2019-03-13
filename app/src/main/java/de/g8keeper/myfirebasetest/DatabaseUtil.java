package de.g8keeper.myfirebasetest;

import com.google.firebase.database.FirebaseDatabase;

public class DatabaseUtil {

    private static final String TAG = DatabaseUtil.class.getSimpleName();

    private static FirebaseDatabase database;

    static {
        database = FirebaseDatabase.getInstance();
    }





}

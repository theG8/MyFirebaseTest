package de.g8keeper.myfirebasetest;

import com.google.firebase.database.FirebaseDatabase;

class DbUtils {

    private static final DbUtils myInstance = new DbUtils();
    private static final String TAG = DbUtils.class.getSimpleName();

    private FirebaseDatabase database;



    public static final String tblUSER = "tblUser";
    public static final String USER = "user";



    static DbUtils getInstance() {
        return myInstance;
    }

    private DbUtils() {
        database = FirebaseDatabase.getInstance();
    }



}

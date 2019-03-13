package de.g8keeper.myfirebasetest;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ChatActivity extends AppCompatActivity {

    private EditText input;
    private TextView output;
    private EditText user;

    private FirebaseDatabase database;
    private DatabaseReference reference;
    private DatabaseReference childReference;

    private ChildEventListener childEventListener;

    private Map<String, Message> messagesMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);





        input = findViewById(R.id.et_input);
        output = findViewById(R.id.tv_output);
        user = findViewById(R.id.et_user);


        final Message fromServer = new Message();

        messagesMap = new HashMap<>();


        database = FirebaseDatabase.getInstance();
        reference = database.getReference("messages");

        childEventListener = new MyChildEventListener();
        reference.addChildEventListener(childEventListener);


        FirebaseMap<Message> fbMap = new FirebaseMap<>(Message.class,database);



//
    }

    public void println(String text) {
        output.append(text + "\n");
    }

    public void send(View view) {
        Message message = new Message(new Random().nextInt(), user.getText().toString(), input.getText().toString());

        childReference = reference.push();


        childReference.setValue(message);

    }

    public void show(View view) {
        showMap();
    }

    public void showMap(){
        String temp = "";

        for(Map.Entry<String, Message> entry: messagesMap.entrySet()){
            temp += entry.getKey() + ":\t" + entry.getValue() + "\n";
        }

        output.setText(temp);
    }


    class MyChildEventListener implements ChildEventListener {
        @Override
        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            Message value = dataSnapshot.getValue(Message.class);

            messagesMap.put(dataSnapshot.getKey(), dataSnapshot.getValue(Message.class));

//            if (value != null) {
//                println(dataSnapshot.getKey() + ": " + value.toString());
//            }
            showMap();
        }

        @Override
        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            Message value = dataSnapshot.getValue(Message.class);

            messagesMap.put(dataSnapshot.getKey(), dataSnapshot.getValue(Message.class));

            showMap();
        }

        @Override
        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            Message value = dataSnapshot.getValue(Message.class);

            messagesMap.remove(dataSnapshot.getValue(Message.class));

            showMap();
        }

        @Override
        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    }

}

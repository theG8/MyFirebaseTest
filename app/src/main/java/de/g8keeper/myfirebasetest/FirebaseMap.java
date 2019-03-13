package de.g8keeper.myfirebasetest;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;


public class FirebaseMap<T>{

    private Map<String,T> mMap;
    private Class<T> mClass;

    FirebaseDatabase db;

    public FirebaseMap(Class<T> cls, FirebaseDatabase database){
        this.mMap = new HashMap<>();
        this.db = database;
    }


    public int size() {
        return mMap.size();
    }

    public boolean isEmpty() {
        return mMap.isEmpty();
    }

    public boolean containsKey(@Nullable Object key) {
        return mMap.containsKey(key);
    }

    public boolean containsValue(@Nullable Object value) {
        return mMap.containsValue(value);
    }


    public T get(@Nullable Object key) {
        return mMap.get(key);
    }


    public T put(@NonNull String key, @NonNull T value) {
        return mMap.put(key, value);
    }


    public T remove(@Nullable Object key) {
        return mMap.remove(key);
    }

    public void putAll(@NonNull Map<? extends String, ? extends T> m) {
        mMap.putAll(m);
    }

    public void clear() {
        mMap.clear();
    }


    public Set<String> keySet() {
        return mMap.keySet();
    }


    public Collection<T> values() {
        return mMap.values();
    }


    public Set<Map.Entry<String, T>> entrySet() {
        return mMap.entrySet();
    }


//    public T getOrDefault(@Nullable Object key, @Nullable T defaultValue) {
//        return mMap.getOrDefault(key, defaultValue);
//    }
//
//    public void forEach(@NonNull BiConsumer<? super String, ? super T> action) {
//        mMap.forEach(action);
//    }
//
//    public void replaceAll(@NonNull BiFunction<? super String, ? super T, ? extends T> function) {
//        mMap.replaceAll(function);
//    }
//
//
//    public T putIfAbsent(@NonNull String key, @NonNull T value) {
//        return mMap.putIfAbsent(key, value);
//    }
//
//    public boolean remove(@Nullable Object key, @Nullable Object value) {
//        return mMap.remove(key, value);
//    }
//
//    public boolean replace(String key, @Nullable T oldValue, T newValue) {
//        return mMap.replace(key, oldValue, newValue);
//    }
//
//
//    public T replace(@NonNull String key, @NonNull T value) {
//        return mMap.replace(key, value);
//    }
//
//
//    public T computeIfAbsent(String key, @NonNull Function<? super String, ? extends T> mappingFunction) {
//        return mMap.computeIfAbsent(key, mappingFunction);
//    }
//
//
//    public T computeIfPresent(String key, @NonNull BiFunction<? super String, ? super T, ? extends T> remappingFunction) {
//        return mMap.computeIfPresent(key, remappingFunction);
//    }
//
//
//    public T compute(String key, @NonNull BiFunction<? super String, ? super T, ? extends T> remappingFunction) {
//        return mMap.compute(key, remappingFunction);
//    }
//
//
//    public T merge(String key, @NonNull T value, @NonNull BiFunction<? super T, ? super T, ? extends T> remappingFunction) {
//        return mMap.merge(key, value, remappingFunction);
//    }




    class MyChildEventListener implements ChildEventListener {
        @Override
        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//            Message value = dataSnapshot.getValue(mClass);

            put(dataSnapshot.getKey(), dataSnapshot.getValue(mClass));

        }

        @Override
        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            Message value = dataSnapshot.getValue(Message.class);

            put(dataSnapshot.getKey(), dataSnapshot.getValue(mClass));


        }

        @Override
        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            Message value = dataSnapshot.getValue(Message.class);

            remove(dataSnapshot.getValue(Message.class));


        }

        @Override
        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    }

//
}

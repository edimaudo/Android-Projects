package com.edimaudo.databasedemo2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
            //myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");
            //myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('Rob',34)");
            //myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('Ed',26)");
            //myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('George',14)");
            //myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('Matthew',69)");
            //myDatabase.execSQL("DELETE FROM users where name like 'R%' LIMIT 1");//delete
            Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE AGE < 20", null);
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");

            c.moveToFirst();
            while (c != null) {
                Log.i("name ", c.getString(nameIndex));
                Log.i("Age ", Integer.toString(c.getInt(ageIndex)));
                c.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

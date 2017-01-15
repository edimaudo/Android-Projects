package com.edimaudo.hackernewsreader;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Map<Integer, String> articleURLs = new HashMap<Integer,String>();
    Map<Integer, String> articleTitles = new HashMap<Integer, String>();
    ArrayList<Integer> articleIds = new ArrayList<Integer>();
    SQLiteDatabase articlesDB;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    ArrayList<String> urls = new ArrayList<String>();

    public class DownloadTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while(data != -1){
                    char current = (char)data;
                    result += current;
                    data = reader.read();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,titles);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        articlesDB = this.openOrCreateDatabase("ARTICLES", MODE_PRIVATE, null);

        articlesDB.execSQL("CREATE TABLE IF NOT EXISTS articles (id INTEGER PRIMARY KEY, articleId INTEGER, url  VARCHAR, title VARCHAR, content VARCHAR)");


        DownloadTask task = new DownloadTask();
        try {
            String result = task.execute("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty").get();

            JSONArray jsonArray = new JSONArray(result);

            articlesDB.execSQL("DELETE FROM articles");

            for (int i = 0; i < 20; i++){

                String articleId = jsonArray.getString(i);
                DownloadTask getArticle = new DownloadTask();
                String articleInfo = getArticle.execute("https://hacker-news.firebaseio.com/v0/item/" + jsonArray.getString(i) + ".json?print=pretty").get();
                JSONObject jsonObject = new JSONObject(articleInfo);
                String articleTitle = jsonObject.getString("title");
                String articleUrl = jsonObject.getString("url");

                articleIds.add(Integer.valueOf(articleId));
                articleTitles.put(Integer.valueOf(articleId),articleTitle);
                articleURLs.put(Integer.valueOf(articleId),articleUrl);


                //since returns are not in order use i to make sure it is in order

                //Use prepared statements to ensure bad data does not get into the app
                String sql = "INSERT INTO articles (articleId, url, title) VALUES(? , ?,  ?)";
                SQLiteStatement statement = articlesDB.compileStatement(sql);
                statement.bindString(1,articleId);
                statement.bindString(2,articleUrl);
                statement.bindString(3,articleTitle);
                statement.execute();

            }

            Cursor c = articlesDB.rawQuery("SELECT * FROM articles ORDER BY articleId DESC",null);
            int articleIdIndex = c.getColumnIndex("articleId");
            int urlIndex = c.getColumnIndex("url");
            int titleIndex = c.getColumnIndex("title");

            c.moveToFirst();

            titles.clear();
            urls.clear();

            do {
                titles.add(c.getString(titleIndex));
                urls.add(c.getString(urlIndex));
            } while(c.moveToNext());

            c.close();
            arrayAdapter.notifyDataSetChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

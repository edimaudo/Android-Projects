package com.edimaudo.mywishlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import data.DatabaseHandler;
import model.MyWish;

public class DisplayWishesActivity extends AppCompatActivity {

    private DatabaseHandler dba;
    private ArrayList<MyWish> dbWishes = new ArrayList<>();
    private WishAdapter wishAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_wishes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        listView = (ListView) findViewById(R.id.list);
        refreshData();
    }

    private void refreshData() {
        dbWishes.clear();
        dba = new DatabaseHandler(getApplicationContext());
        ArrayList<MyWish> wishesFromDB = dba.getWishes();
        for (int i = 0; i < wishesFromDB.size(); i++){
            String title = wishesFromDB.get(i).getTitle();
            String dataText = wishesFromDB.get(i).getRecordDate();
            String content = wishesFromDB.get(i).getContent();
            int mid = wishesFromDB.get(i).getItemId();
            MyWish myWish = new MyWish();
            myWish.setTitle(title);
            myWish.setContent(content);
            myWish.setRecordDate(dataText);
            myWish.setItemId(mid);
            dbWishes.add(myWish);

        }
        dba.close();
        //setup adapter
        wishAdapter = new WishAdapter(DisplayWishesActivity.this,R.layout.wish_row,dbWishes);
        listView.setAdapter(wishAdapter);
        wishAdapter.notifyDataSetChanged();

    }

    public class WishAdapter extends ArrayAdapter<MyWish>{
        Activity activity;
        int layoutResource;
        MyWish wish;
        ArrayList<MyWish> mData = new ArrayList<>();
        public WishAdapter(Activity act, int resource, ArrayList<MyWish> data) {
            super(act, resource, data);
            activity = act;
            layoutResource = resource;
            mData = data;
            notifyDataSetChanged();

        }

        @Override
        public MyWish getItem(int position) {
            return mData.get(position);
        }

        @Override
        public int getPosition(MyWish item) {
            return super.getPosition(item);
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            ViewHolder holder = null;
            if(row == null || (row.getTag()) == null){
                LayoutInflater inflater = LayoutInflater.from(activity);
                row = inflater.inflate(layoutResource,null);
                holder = new ViewHolder();
                holder.mTitle = (TextView) row.findViewById(R.id.name);
                holder.mDate = (TextView) row.findViewById(R.id.dateText);
                row.setTag(holder);
            } else {
                holder = (ViewHolder) row.getTag();
            }
            holder.myWish = getItem(position);
            holder.mTitle.setText(holder.myWish.getTitle());
            holder.mDate.setText(holder.myWish.getRecordDate());

            final ViewHolder finalHolder = holder;
            holder.mTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String text = finalHolder.myWish.getContent().toString();
                    String dateText = finalHolder.myWish.getRecordDate().toString();
                    String title = finalHolder.myWish.getTitle().toString();
                    int mid = finalHolder.myWish.getItemId();

                    Intent i = new Intent(DisplayWishesActivity.this,WishDetailActivity.class);
                    i.putExtra("content",text);
                    i.putExtra("date",dateText);
                    i.putExtra("title",title);
                    i.putExtra("id", mid);
                    startActivity(i);

                }
            });

            return row;

        }

        //view holder patter
        class ViewHolder{
            MyWish myWish;
            TextView mTitle;
            TextView mId;
            TextView mContent;
            TextView mDate;
        }


    }

}

package com.edimaudo.pikture.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.edimaudo.pikture.R;
import com.edimaudo.pikture.adapter.GalleryAdapter;
import com.edimaudo.pikture.app.AppController;
import com.edimaudo.pikture.model.Image;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class pictures extends AppCompatActivity {
  public String[] picture_tags = {"animals", "rabbit", "cat", "puppy"};
  private String TAG = "INFO";
  public String endpoint = "https://api.flickr.com/services/feeds/photos_public.gne?format=json";
  private ArrayList<Image> images;
  private ProgressDialog pDialog;
  private GalleryAdapter mAdapter;
  private RecyclerView recyclerView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pictures);

    //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    //setSupportActionBar(toolbar);

    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

    pDialog = new ProgressDialog(this);
    images = new ArrayList<>();
    mAdapter = new GalleryAdapter(getApplicationContext(), images);

    RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.setAdapter(mAdapter);

    fetchImages();

            /* recyclerView.addOnItemTouchListener(new GalleryAdapter.RecyclerTouchListener(getApplicationContext(), recyclerView, new GalleryAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("images", images);
                bundle.putInt("position", position);

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                SlideshowDialogFragment newFragment = SlideshowDialogFragment.newInstance();
                newFragment.setArguments(bundle);
                newFragment.show(ft, "slideshow");
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));*/
  }


  public void fetchImages() {
    pDialog.setMessage("Downloading images...");
    pDialog.show();
    String requestBody = "";
    JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,
            endpoint,
            requestBody,
            new Response.Listener<JSONObject>() {
              @Override
              public void onResponse(JSONObject response) {
                try {
                  JSONArray itemArray = response.getJSONArray("Items");
                  images.clear();
                  for (int i = 0; i < itemArray.length(); i++){
                      Image image = new Image();
                      JSONObject object = itemArray.getJSONObject(i);
                      image.setName(object.getString("title"));
                      JSONObject url = object.getJSONObject(("media"));
                      image.setMedia(url.getString("m"));
                      images.add(image);
                  }

                } catch (JSONException e){
                  Log.e(TAG, "Json parsing error: " + e.getMessage());
                }
                mAdapter.notifyDataSetChanged();
              }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                  Log.e(TAG, "Error: " + error.getMessage());
                  pDialog.hide();
                }

    });

    // Adding request to request queue
    AppController.getInstance().addToRequestQueue(req);


  }

}
package data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

import model.Event;
import musicevent.magadistudio.com.musicevent.ActivityEventDetails;
import musicevent.magadistudio.com.musicevent.AppController;
import musicevent.magadistudio.com.musicevent.R;

/**
 * Created by paulodichone on 3/26/15.
 */
public class CustomListviewAdapter extends ArrayAdapter<Event> {
    private LayoutInflater inflater;
    private ArrayList<Event> data;
    private Activity mContext;
    private int layoutResourceId;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();


    public CustomListviewAdapter(Activity context, int resource, ArrayList<Event> objs) {
        super(context, resource, objs);
        data = objs;
        mContext = context;
        layoutResourceId = resource;
    }



    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getPosition(Event item) {
        return super.getPosition(item);
    }

    @Override
    public Event getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View row = convertView;
        ViewHolder viewHolder = null;

        if ( row == null) {

             inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(layoutResourceId, parent, false);

            viewHolder = new ViewHolder();


            //Get references to our views
            viewHolder.bandImage = (NetworkImageView)row.findViewById(R.id.bandImage);
            viewHolder.headliner = (TextView) row.findViewById(R.id.headLinerText);
            viewHolder.venue = (TextView) row.findViewById(R.id.venueText);
            viewHolder.when = (TextView) row.findViewById(R.id.whenText);
            viewHolder.where = (TextView) row.findViewById(R.id.whereText);

            row.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) row.getTag();
        }

        viewHolder.event = data.get(position);

        //We can now display the data

        viewHolder.headliner.setText("Headliner: " + viewHolder.event.getHeadLiner());
        viewHolder.venue.setText("Venue: " + viewHolder.event.getVenueName());
        viewHolder.when.setText("When: " + viewHolder.event.getStartDate());
        viewHolder.where.setText("Where: " + viewHolder.event.getStreet() + ", "
                + viewHolder.event.getCity() + ", " + viewHolder.event.getCountry());
        viewHolder.bandImage.setImageUrl(viewHolder.event.getUrl(), imageLoader);
        viewHolder.website = viewHolder.event.getWebsite();

       Log.v("VENUE", viewHolder.event.getVenueName());


        final ViewHolder finalViewHolder = viewHolder;
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, ActivityEventDetails.class);
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("eventObj", finalViewHolder.event);
                i.putExtras(mBundle);
                mContext.startActivity(i);



            }
        });



        return row;
    }





    public class ViewHolder {
        Event event;
        TextView headliner;
        TextView venue;
        TextView where;
        TextView when;
        String website;
        NetworkImageView bandImage;


    }













}

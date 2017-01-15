package data;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.edimaudo.myevents.AppController;
import com.edimaudo.myevents.R;

import java.util.ArrayList;

import model.Event;
/**
 * Created by edima on 2016-07-04.
 */
public class CustomListViewAdapter extends ArrayAdapter<Event> {

    private LayoutInflater inflater;
    private ArrayList<Event> data;
    private Activity mContext;
    private int layoutResourceId;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListViewAdapter(Activity context, int resource,ArrayList<Event> objs) {
        super(context, resource, objs);
        data = objs;
        mContext = context;
        layoutResourceId = resource;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Event getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getPosition(Event item) {
        return super.getPosition(item);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder viewHolder = null;

        if (row == null){
            inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(layoutResourceId,parent,false);
            viewHolder = new ViewHolder();

            //Ger view references
            viewHolder.bandImage = (NetworkImageView) row.findViewById(R.id.bandImage);
            viewHolder.when = (TextView) row.findViewById(R.id.whenText);
            viewHolder.where = (TextView) row.findViewById(R.id.whereText);
            viewHolder.headLiner = (TextView) row.findViewById(R.id.headLinerText);
            viewHolder.venue = (TextView) row.findViewById(R.id.venueText);
            row.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)row.getTag();
        }
        viewHolder.event = data.get(position);

        //display data
        viewHolder.headLiner.setText("Headliner: " + viewHolder.event.getHeadLiner());
        viewHolder.venue.setText("Venue: " + viewHolder.event.getVenueName());
        viewHolder.where.setText("Where " + viewHolder.event.getStreet() + ", " +
        viewHolder.event.getCity() + ", " + viewHolder.event.getCountry());
        viewHolder.when.setText("When " + viewHolder.event.getStartDate());
        viewHolder.bandImage.setImageUrl(viewHolder.event.getUrl(),imageLoader);
        viewHolder.website = viewHolder.event.getWebsite();
        return row;
        //return super.getView(position, convertView, parent);
    }

    //put all view data into a single place
    public class ViewHolder{
        TextView headLiner;
        TextView venue;
        TextView where;
        TextView when;
        String website;
        NetworkImageView bandImage;
        Event event;
    }
}

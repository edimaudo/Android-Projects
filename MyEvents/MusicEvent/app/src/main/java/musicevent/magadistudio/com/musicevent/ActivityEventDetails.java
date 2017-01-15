package musicevent.magadistudio.com.musicevent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import model.Event;


public class ActivityEventDetails extends ActionBarActivity {

    private Event event;
    private TextView venue;
    private TextView where;
    private TextView when;
    private TextView headLiner;
    private NetworkImageView bandImage;
    ImageLoader imageLoader =  AppController.getInstance().getImageLoader();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_event_details);

        //Get serialized object
        event = (Event) getIntent().getSerializableExtra("eventObj");


        headLiner = (TextView) findViewById(R.id.detsHeadliner);
        bandImage = (NetworkImageView) findViewById(R.id.detsBandImage);
        venue = (TextView) findViewById(R.id.detsVenue);
        where = (TextView) findViewById(R.id.detsWhere);
        when = (TextView) findViewById(R.id.detsWhen);


        headLiner.setText("HeadLiner: " + event.getHeadLiner());
        bandImage.setImageUrl(event.getUrl(), imageLoader);
        venue.setText("Venue: " + event.getVenueName());
        where.setText("Where: " + event.getStreet() + ", " + event.getCity() + ", "
        + event.getCountry());
        when.setText("When: " + event.getStartDate());

        Log.v("Event Object data: ", event.getVenueName());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_event_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_websiteId) {

            String url = event.getWebsite();

            if (!url.equals("")) {
                Intent i =  new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }else {
                Toast.makeText(getApplicationContext(), "Website not available", Toast.LENGTH_LONG).show();
            }

        }

        return super.onOptionsItemSelected(item);
    }
}

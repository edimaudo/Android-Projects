package uiviewsxml.magadistudio.com.dogorcatperson;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class ResultActivity extends ActionBarActivity {

    private TextView result;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = (TextView) findViewById(R.id.resultTextView);
        imageView = (ImageView) findViewById(R.id.petImageView);

        Bundle extras = getIntent().getExtras();

         if (extras != null){

             int catResult = extras.getInt("catCounter");
             int dogResult = extras.getInt("dogCounter");

              if (catResult > dogResult){

                  result.setText("Cat Person!!");
                  imageView.setImageDrawable(getResources().getDrawable(R.drawable.icon_lg_cat));

              }else if (dogResult > catResult){


                  result.setText("Dog Person!!");
                  imageView.setImageDrawable(getResources().getDrawable(R.drawable.icon_lg_dog));


              } else {

                  result.setText("Neither!");
              }
         }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

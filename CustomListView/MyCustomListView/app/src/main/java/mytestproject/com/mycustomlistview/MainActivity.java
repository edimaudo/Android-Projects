package mytestproject.com.mycustomlistview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private ListView listView;
    private CustomListViewAdapter customListViewAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final String[] bookTitles = new String[]{
                "The Alchemist",
                "The Giver",
                "How to Kill a Mockingbird",
                "Lost in Paradise",
                "The Complete Android and Java Developer...",
                "Titanic",
                "The Kite Runner",
                "Lord of the Rings",
                "The Hobbit",
                "Java in a Nutshell",
                "The Social Network",
                "Game Programming All in One"

        };

        final String[] bookPages = new String[]{
                "300 pages",
                "350 pages",
                "900 pages",
                "230 pages",
                "1200 pages",
                "450 pages",
                "350 pages",
                "120 pages",
                "2300 pages",
                "2100 pages",
                "329 pages",
                "1978 pages"

        };

        final String[] authors = new String[]{

                "Paulo Coelho",
                "Lois Lowry",
                "Harper Lee",
                "Somell Author!",
                "Paulo and Fahd",
                "Simon Adams",
                "Khaled Hosseini",
                "J. R. R. Tolkien",
                "J. R. R. Tolkien",
                "Flannagan",
                "Ben Mezrich",
                "Harbour"

        };

        ArrayList<HashMap<String, String>> authorList = new ArrayList<>();

        for (int i = 0; i < 10; i++){

            HashMap<String, String> data = new HashMap<>();
            data.put("title", bookTitles[i]);
            data.put("pages", bookPages[i]);
            data.put("author", authors[i]);


            authorList.add(data);

        }

        listView = (ListView) findViewById(R.id.list);

        //Setup adapter
        customListViewAdapter = new CustomListViewAdapter(getApplicationContext(), authorList);
        listView.setAdapter(customListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int myPosition = position;

                String itemClickedId = listView.getItemAtPosition(myPosition).toString();

                Toast.makeText(getApplicationContext(), "Id Clicked: " +itemClickedId, Toast.LENGTH_LONG).show();




            }
        });





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

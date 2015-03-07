package com.example.app;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class mainMenuActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "com.example.app.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        // Button pushMe = (Button) findViewById(R.id.button1);
        // TextView view = (TextView) findViewById(R.id.text1);
        // pushMe.setOnClickListener(new ListClickHandler(view));


        ListView listView1 = (ListView) findViewById(R.id.listView1);
        listItem[] items = new listItem[]{
                new listItem(1, "Red Wings", 1, "url"),
                new listItem(1, "Red Wings", 2, "url"),
                new listItem(1, "Red Wings", 3, "url"),
                new listItem(1, "Red Wings", 4, "url"),
                new listItem(1, "Red Wings", 5, "url"),
                new listItem(1, "Red Wings", 6, "url"),
                new listItem(1, "Red Wings", 7, "url"),
                new listItem(1, "Red Wings", 8, "url"),
                new listItem(1, "Red Wings", 9, "url"),
                new listItem(2, "Dallas Stars", 10, "url")
        };

        ArrayAdapter<listItem> adapter = new ArrayAdapter<listItem>(this,
                R.layout.list_item, items);

        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d("test", "clicked");
                listItem itemClicked = (listItem)adapterView.getItemAtPosition(position);
                itemClicked.count++;
                String item = ((TextView)view).getText().toString();
                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();
            }
        });

    }


    public void newGameClicked(View view) {
        Intent intent = new Intent(this,gamePlayingActivity.class);

        String message = "NewGame";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);


        // Do something in response to button
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }


    public void listViewOnClick(View v) {
// do something when the button is clicked
        Button button = (Button) v;
        button.setText("I've been clicked!");


    }
}

package com.example.app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class signUpActivity extends ActionBarActivity {
    private EditText mUsernameEntered;
    private EditText mPasswordEntered;
    private ProgressDialog pDialog;
    JSONParser jsonParser = new JSONParser();


    private static final String TAG_SUCCESS = "success";
    private static final String TAG_PRODUCTS = "products";
    private static final String TAG_PID = "pid";
    private static final String TAG_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
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

    public void signUpClicked(View view)  {
//        try {
//            System.out.println("Loading driver...");
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver loaded!");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Cannot find the driver in the classpath!", e);
//        }
//
//        String url = "jdbc:mysql://localhost:80/decksdatabase";
//        String username = "Casey";
//        String password = "Edge";
//        Connection connection = null;
//
//        try {
//            System.out.println("Connecting database...");
//            connection = DriverManager.getConnection(url, username, password);
//            System.out.println("Database connected!");
//        } catch (SQLException e) {
//            throw new RuntimeException("Cannot connect the database!", e);
//        } finally {
//            System.out.println("Closing the connection.");
//            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
//        }


        String url_addUser = "http://localhost/addAUser.php";


        mUsernameEntered = (EditText) findViewById(R.id.editTextUserName);
        mPasswordEntered = (EditText) findViewById(R.id.editTextPassword);

        new CreateNewProduct().execute();
//
//        String userNameString = mUsernameEntered.getText().toString();
//        String passWordString = mPasswordEntered.getText().toString();
//
//
//        String url = "jdbc:mysql://localhost:80/decksdatabase;";
//        Connection con = DriverManager.getConnection(url,Casey,Edge);
//        Statement s1 = con.createStatement();
//        ResultSet rs = s1.executeQuery("INSERT INTO userstable VALUES ("+userNameString+","+passWordString+")");
//
//        Intent intent = new Intent(this,mainMenuActivity.class);
//        String message = "goingToMainMenu";
//        intent.putExtra("Signup was clicked", message);
//        startActivity(intent);
    }

    /**
     * Background Async Task to Create new product
     */
    class CreateNewProduct extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(signUpActivity.this);
            pDialog.setMessage("Creating Product..");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        /**
         * Creating product
         */
        protected String doInBackground(String... args) {
            String name = mUsernameEntered.getText().toString();
            String password = mPasswordEntered.getText().toString();

            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("userName", name));
            params.add(new BasicNameValuePair("password", password));

            // getting JSON Object
            // Note that create product url accepts POST method
            String url_addUser = "http://10.0.0.4/Users/addAUser.php";
            JSONObject json;
            json = jsonParser.makeHttpRequest(url_addUser,
                    "POST", params);

            // check log cat fro response
            Log.d("Create Response", json.toString());

            // check for success tag
            try {
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    // successfully created product
                    Intent i = new Intent(getApplicationContext(), mainMenuActivity.class);
                    startActivity(i);

                    // closing this screen
                    finish();
                } else {
                    // failed to create product
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * *
         */
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once done
            pDialog.dismiss();
        }

    }
}
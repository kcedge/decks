package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;


public class loginActivity extends ActionBarActivity {

    int currentCardNumber = 0;
    private EditText mUsernameEntered;
    private EditText mPasswordEntered;
    public final static String EXTRA_MESSAGE = "com.example.app.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void loginButtonClicked(View view) {


        mUsernameEntered = (EditText)findViewById(R.id.editText1);
        mPasswordEntered = (EditText)findViewById(R.id.editText2);
//
//        String userNameString = mUsernameEntered.getText().toString();
//        String passWordString = mPasswordEntered.getText().toString();

        String userNameString = "caseyedge";
        String passWordString = "gizmo00";

            if (userNameString.equals("caseyedge") &&
                    passWordString.equals("gizmo00")) {

            Intent intent = new Intent(this,mainMenuActivity.class);
            String message = "LoginClicked";
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);//correcct password
        } else {
//wrong password

            mUsernameEntered.setText("");
            mPasswordEntered.setText("");
        }
    }

    public void signInClicked(View view) {
        Intent intent = new Intent(this,signUpActivity.class);
        String message = "goingToSignUpPage";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}

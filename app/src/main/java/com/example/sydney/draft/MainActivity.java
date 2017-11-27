package com.example.sydney.draft;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    //user's variables
    String name, insta, fb, twitter, email, snap, phone;

    //Button button1;

    EditText user_name, edit_insta, edit_snap, edit_fb, edit_twitter, edit_email, edit_phone;


    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        /*

        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                name = user_name.getText().toString();
                email = edit_email.getText().toString();
                fb = edit_fb.getText().toString();
                snap = edit_snap.getText().toString();
                twitter = edit_twitter.getText().toString();
                insta = edit_insta.getText().toString();
                phone = Integer.valueOf(edit_phone.getText().toString());

                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();

            }
        });

        */
    }

    //public static final String EXTRA_MESSAGE = "com.example.Draft.MESSAGE";

    public void make_Profile (View v){

        user_name = (EditText) findViewById(R.id.user_name);
        edit_insta = (EditText) findViewById(R.id.edit_insta);
        edit_snap = (EditText) findViewById(R.id.edit_snap);
        edit_fb = (EditText) findViewById(R.id.edit_fb);
        edit_twitter = (EditText) findViewById(R.id.edit_twitter);
        edit_email = (EditText) findViewById(R.id.edit_email);
        edit_phone = (EditText) findViewById(R.id.edit_phone);

        name = user_name.getText().toString();
        email = edit_email.getText().toString();
        fb = edit_fb.getText().toString();
        snap = edit_snap.getText().toString();
        twitter = edit_twitter.getText().toString();
        insta = edit_insta.getText().toString();
        phone = edit_phone.getText().toString();

        // User inputted data on next page
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        Bundle mBundle = new Bundle();
        mBundle.putString("passedName", name);
        mBundle.putString("passedEmail", email);
        mBundle.putString("passedPhone", phone);
        mBundle.putString("passedInsta", insta);
        mBundle.putString("passedSnap", snap);
        mBundle.putString("passedFb", fb);
        mBundle.putString("passedTwitter", twitter);
        i.putExtras(mBundle);
        startActivity(i);

    }

}

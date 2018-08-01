package com.example.astghik.searchexample;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class ScrollingActivity extends AppCompatActivity {
    ImageView image;
    TextView descr;
    String mail;
    String phone;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView image = findViewById(R.id.scrolling_image);
        String url = getIntent().getStringExtra(UserAdapter.KEY);
        Glide.with(this).load(url).into(image);
        Toast.makeText(this, url, Toast.LENGTH_LONG).show();
        int position = getIntent().getIntExtra(UserAdapter.KEY, 0);
        final User user = DataProvider.users.get(position);
        toolbar.setTitle(user.getName());
        descr = findViewById(R.id.descrip);
        descr.setText(user.getDescription());
        image = findViewById(R.id.scrolling_image);
        Picasso.get().load(user.getImageUrl()).into(image);



    }
}

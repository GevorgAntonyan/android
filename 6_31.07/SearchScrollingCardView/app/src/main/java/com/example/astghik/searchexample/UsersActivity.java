package com.example.astghik.searchexample;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends AppCompatActivity {
    private UserAdapter userAdapter;
    public static final int RESULT_LOAD_IMG = 5;
    private String name;
    private String description;
    private String uri;
    private String phone;
    private String email;

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            uri = String.valueOf(data.getData());
        }else {
            uri = "https://cdn.pixabay.com/photo/2013/04/06/11/50/image-editing-101040_960_720.jpg";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final RelativeLayout layout = findViewById(R.id.addList);
        ImageView add = findViewById(R.id.add);
        ImageButton close = findViewById(R.id.addClose);
        Button addImage = findViewById(R.id.addImage);
        Button addUser = findViewById(R.id.addUser);
        click(layout, add, close, addImage, addUser);
        DataProvider.fillUsers();
        List<User> users = DataProvider.users;
        RecyclerView rv = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        setUsers();
        userAdapter = new UserAdapter(users, this);
        rv.setAdapter(userAdapter);
        rv.setLayoutManager(layoutManager);
    }

    private void click(final RelativeLayout layout, ImageView add, ImageButton close, Button addImage, Button addUser) {
        addUser.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText text = findViewById(R.id.addName);
                name = text.getText().toString();
                text = findViewById(R.id.addDescription);
                description = text.getText().toString();
                text = findViewById(R.id.addPhone);
                email = text.getText().toString();
                text = findViewById(R.id.addEmail);
                phone = text.getText().toString();
                if (null == uri) {
                    uri = "https://cdn.pixabay.com/photo/2013/04/06/11/50/image-editing-101040_960_720.jpg";
                }
                if(name.equals("")) {
                    name = "name";
                }
                if(description.equals("")) {
                    description = "Text";
                }
                if(phone.equals("")) {
                    phone = "+374000000000;";
                }
                if(email.equals("")) {
                    email = "email@gmail.com";
                }
                DataProvider.users.add(new User(uri, name, description, email, phone, 5F));
                layout.setVisibility(View.INVISIBLE);
                name = null;
                description = null;
                phone = null;
                email = null;
                uri = null;
                userAdapter.notifyDataSetChanged();

            }
        });
        add.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setVisibility(View.VISIBLE);
            }
        });
        close.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setVisibility(View.INVISIBLE);
            }
        });
        addImage.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);

            }
        });
    }

    private void setUsers() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        SearchView search = (SearchView) menu.findItem(R.id.search).getActionView();

        assert manager != null;
        search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                userAdapter.getFilter().filter(query);
                userAdapter.notifyDataSetChanged();
                return true;
            }

        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}

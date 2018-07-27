package com.color.gevorg.changefrangment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.Fragment1Listener{
    Fragment1 fragment1;
    Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment1, fragment1)
                .replace(R.id.fragment2, fragment2).commit();


    }

    @Override
    public void onInputASent(String i) {
        fragment2.inputText(i);
    }
}

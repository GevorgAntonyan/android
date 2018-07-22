package com.color.gevorg.selectimage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView area;
    public boolean bool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        area = (TextView) findViewById(R.id.view);
        area.setText(getIntent().getStringExtra("this"));
        back();
    }

    public void back() {
        Button button = (Button) findViewById(R.id.back);
        button.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent myIntent = new Intent(Main2Activity.this, MainActivity.class);
                        startActivity(myIntent);
                    }
                }
        );
    }
}



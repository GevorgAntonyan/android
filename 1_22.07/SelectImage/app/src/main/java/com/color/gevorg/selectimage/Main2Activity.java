package com.color.gevorg.selectimage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        area = findViewById(R.id.view);
        area.setText(getIntent().getStringExtra("this"));
        back();
    }

    public void back() {
        Button button = findViewById(R.id.back);
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



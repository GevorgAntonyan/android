package com.color.gevorg.change;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.color.gevorg.change.MainActivity.NAME;

public class Main2Activity extends AppCompatActivity {
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text = findViewById(R.id.text2);
        text.setText(getIntent().getStringExtra(getString(R.string.MY_INTENT)));
        back();
    }

    public void back () {
        Button back = findViewById(R.id.back);
        final String resoult = text.getText().toString();
        back.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra(NAME, text.getText().toString());
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
        );
    }
}

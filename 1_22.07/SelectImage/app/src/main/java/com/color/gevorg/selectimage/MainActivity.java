package com.color.gevorg.selectimage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button button1, button2, show;
    private ImageView image;
    private CheckBox check;
    private EditText edit;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image();

    }

    public void image () {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        image = findViewById(R.id.image);
        check = findViewById(R.id.checkbox);
        show = findViewById(R.id.show);
        edit = findViewById(R.id.edit);
        button1.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        image.setImageResource(R.drawable.image1);
                    }
                }
        );
        button2.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        image.setImageResource(R.drawable.image2);
                    }
                }
        );
        check.setOnCheckedChangeListener(
                new CheckBox.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(check.isChecked()) {
                            image.setVisibility(View.VISIBLE);
                        } else   {
                            image.setVisibility(View.INVISIBLE);
                        }
                    }
                }
        );
        show.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        text = edit.getText().toString();
                        if (text.length() != 0) {
                            change();
                        }
                    }
                }
        );

    }

    public void change(){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("this", text);
        startActivity(intent);
    }
}

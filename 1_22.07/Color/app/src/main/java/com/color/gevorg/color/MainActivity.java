package com.color.gevorg.color;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SeekBar seek, seek1, seek2;
    private int red, green, blue;
    private LinearLayout layout;
    private TextView view1, view2, view3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        color();
    }
    public void color () {
        this.seek = (SeekBar) findViewById(R.id.red);
        this.seek1 = (SeekBar) findViewById(R.id.green);
        this.seek2 = (SeekBar) findViewById(R.id.blue);
        this.layout = (LinearLayout) findViewById(R.id.layout);
        this.view1 = (TextView) findViewById(R.id.rec1);
        this.view2 = (TextView) findViewById(R.id.rec2);
        this.view3 = (TextView) findViewById(R.id.rec3);
        seek.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        red = 255 - seek.getProgress();
                        seek.setBackgroundColor(Color.rgb(red, 0, 0));
                        layout.setBackgroundColor(Color.rgb(red, green, blue));
                        String text = Integer.toString(red);
                        view1.setText(text);
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }

                }
        );
        seek1.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        green = 255 - seek1.getProgress();
                        seek1.setBackgroundColor(Color.rgb(0, green, 0));
                        layout.setBackgroundColor(Color.rgb(red, green, blue));
                        String text = Integer.toString(green);
                        view2.setText(text);
                        }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }

                }

        );
        seek2.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        blue = 255 - seek2.getProgress();
                        seek2.setBackgroundColor(Color.rgb(0, 0, blue));
                        layout.setBackgroundColor(Color.rgb(red, green, blue));
                        String text = Integer.toString(blue);
                        view3.setText(text);
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }

                }

        );

    }
}

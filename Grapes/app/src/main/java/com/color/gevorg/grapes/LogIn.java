package com.color.gevorg.grapes;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        click();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ImageView image = findViewById(R.id.image);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            image.setImageResource(R.drawable.horizon);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            image.setImageResource(R.drawable.vertical);
        }
    }



    private void click() {
        final EditText nickname = findViewById(R.id.nickname);
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String var = nickname.getText().toString();
                        if (isValid(var)) {
                            Toast.makeText(LogIn.this, "true", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LogIn.this, "false", Toast.LENGTH_SHORT).show();

                        }
                    }
                }
        );
    }

    public static boolean isValid(String str) {
        if(str.length() > 10 || str.length() == 0) {
            return false;
        }
        for(int i = 0; i < str.length(); ++i) {
            if (!((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') ||
                    (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') ||
                    (str.charAt(i) >= '0' && str.charAt(i) <= '9'))) {

                return false;
            }
        }
        return true;
    }
}

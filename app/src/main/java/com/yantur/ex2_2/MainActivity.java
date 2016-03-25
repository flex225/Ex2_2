package com.yantur.ex2_2;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND_MULTIPLE.equals(action) && type != null) {
            if (type.startsWith("text/")) {
                handleSendMultipleTexts(intent);
            }
        }
    }

    private void handleSendMultipleTexts(Intent intent) {
        ArrayList<String> data = intent.getStringArrayListExtra("images");
        if (data != null) {
            LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linear_layout);
            for (String s:
                 data) {
                TextView textView = new TextView(this);
                textView.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                textView.setText(s);
                linearLayout.addView(textView);
            }

        }
    }
}

package com.novaes.prove05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        //Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        if(intent != null){
            Bundle params = intent.getExtras();
            if(params != null){
                String book = params.getString("book");
                String chapter = params.getString("chapter");
                String verse = params.getString("verse");

                TextView bookTV = (TextView) findViewById(R.id.textView);
                TextView chapterTV = (TextView) findViewById(R.id.textView2);
                TextView verseTV = (TextView) findViewById(R.id.textView3);

                bookTV.setText("Book: " + book);
                chapterTV.setText("Chapter: " + chapter);
                verseTV.setText("Verse: " + verse);

            }
        }
    }

    public void accepted(View view){
        Intent intent = new Intent();
        intent.putExtra("msg", "Accepted");

        setResult(1, intent);
        finish();
    }

    public void rejected(View view){
        Intent intent = new Intent();
        intent.putExtra("msg", "Rejected");

        setResult(2, intent);
        finish();
    }
}
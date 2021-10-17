package com.novaes.prove05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int Const_Screen_1 = 1;
    public static final int Const_Screen_2 = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**Called when the user taps the Send button */
    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText book = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText chapter = (EditText) findViewById(R.id.editTextNumber);
        EditText verse = (EditText) findViewById(R.id.editTextNumber2);

        Bundle params = new Bundle();
        params.putString("book", book.getText().toString());
        params.putString("chapter", chapter.getText().toString());
        params.putString("verse", verse.getText().toString());

        intent.putExtras(params);
        startActivityForResult(intent, Const_Screen_1);

    }

    protected void onActivityResult(int codeScreen, int result, Intent intent) {

        super.onActivityResult(codeScreen, result, intent);
        if (codeScreen == Const_Screen_1) {
            Bundle params = intent.getExtras();
            if (params != null) {
                String msg = params.getString("msg");
                Toast.makeText(this, "Screen 1 -> Result: " + result + " | Msg: " + msg, Toast.LENGTH_LONG).show();
            }
        }
    }
}
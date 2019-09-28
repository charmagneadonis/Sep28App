package com.adonis.sep28app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.editText);
    }

    public void writeData (View v) {
        String data =  input.getText().toString();
        FileOutputStream writer = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer.write(data.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d("error", "File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("error", "IO Error");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("error", "File Not Found");
            }
        }

        Toast.makeText(this, "Data Saved", Toast.LENGTH_LONG).show();
    }

    public void showData (View v) {
        FileInputStream reader = null;
        String data = "";
        try {
            reader = openFileInput("data1.txt");
            int token;
            while ((token = reader.read()) != -1) {
                data = data + (char)token;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d("error", "File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("error", "IO Error");
        }

        Toast.makeText(this, data, Toast.LENGTH_LONG).show();

    }
}

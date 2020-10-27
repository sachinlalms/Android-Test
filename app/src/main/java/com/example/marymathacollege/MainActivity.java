package com.example.marymathacollege;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.marymathacollege.faculty.UpdateFaculty;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView uploadnotice,addgalleryimage,addebook,addfacalty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uploadnotice=findViewById(R.id.addNotice);
        addgalleryimage=findViewById(R.id.addgalleryimage);
        addfacalty= findViewById(R.id.addfacalty);

        addebook=findViewById(R.id.addebook);



        uploadnotice.setOnClickListener(this);
        addgalleryimage.setOnClickListener(this);
        addebook.setOnClickListener(this);
        addfacalty.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.addNotice:
                 intent = new Intent(MainActivity.this, UploadNotice.class);
                startActivity(intent);
                break;
            case R.id.addgalleryimage:
                 intent = new Intent(MainActivity.this, UploadImage.class);
                startActivity(intent);
                break;

             case R.id.addebook:
                 intent = new Intent(MainActivity.this, UploadPdf.class);
                startActivity(intent);
                break;
             case R.id.addfacalty:
                 intent = new Intent(MainActivity.this, UpdateFaculty.class);
                startActivity(intent);
                break;
        }

    }
}
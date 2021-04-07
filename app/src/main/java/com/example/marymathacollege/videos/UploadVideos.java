package com.example.marymathacollege.videos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.marymathacollege.R;
import com.example.marymathacollege.faculty.AddTeacher;
import com.example.marymathacollege.faculty.TeacherData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class UploadVideos extends AppCompatActivity {


    private EditText addVideoName,addVideoPost;
    private Spinner addVideocategory;
    private Button addVideobtn;
    private final int REQ=1;
    private String category;
    private String name,post;
    private ProgressDialog pd;
    FirebaseDatabase database;
    private DatabaseReference reference,dbref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_videos);
        addVideoName = findViewById(R.id.addVideoName);
        addVideoPost = findViewById(R.id.addVideoPost);
        addVideocategory = findViewById(R.id.addVideocategory);
        addVideobtn= findViewById(R.id.addVideobtn);
        reference = database.getInstance().getReference().child("Videos");
        pd = new ProgressDialog(this);



        addVideobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkValidation();
            }
        });
    }

    private void checkValidation() {
        name = addVideoName.getText().toString();

        post = addVideoPost.getText().toString();

        if(name.isEmpty()){
            addVideoName.setError("Empty");
            addVideoName.requestFocus();
        }else if(post.isEmpty()){
            addVideoPost.setError("Empty");
            addVideoPost.requestFocus();
        }else {
            insertData();

        }
    }


    private void insertData() {


        dbref = reference.child(name);
        final String uniquekey = dbref.push().getKey();

        VideoData videoData = new VideoData(name,post,uniquekey);

        dbref.child(uniquekey).setValue(videoData).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                pd.dismiss();
                Toast.makeText(UploadVideos.this, "Video Added Successfully", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(UploadVideos.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
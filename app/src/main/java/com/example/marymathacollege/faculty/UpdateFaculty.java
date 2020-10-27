package com.example.marymathacollege.faculty;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.marymathacollege.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView csDept,phyDept,matDept,cheDept;
    private LinearLayout CsnoData,chenoData,matnoData,phynoData;
    private List<TeacherData> list1,list2,list3,list4;
    private DatabaseReference reference,dbref;
    private TeacherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);
        cheDept = findViewById(R.id.cheDept);
        chenoData=findViewById(R.id.chenoData);
        matDept=findViewById(R.id.matDept);
        matnoData=findViewById(R.id.matnoData);
        phyDept=findViewById(R.id.phyDept);
        phynoData=findViewById(R.id.phynoData);
        csDept=findViewById(R.id.csDept);
        CsnoData=findViewById(R.id.CsnoData);

        reference= FirebaseDatabase.getInstance().getReference().child("teacher");
        csDept();
        matDept();
        phyDept();
        cheDept();

        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateFaculty.this,AddTeacher.class));
            }
        });
    }

    private void csDept() {
        dbref = reference.child("Computer Science");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    CsnoData.setVisibility(View.VISIBLE);
                    csDept.setVisibility(View.GONE);
                }else {

                    CsnoData.setVisibility(View.GONE);
                    csDept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data= snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDept.setHasFixedSize(true);
                    csDept.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter= new TeacherAdapter(list1, UpdateFaculty.this,"Computer Science");
                    csDept.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void cheDept() {
        dbref = reference.child("Chemistry");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if(!snapshot.exists()){
                    chenoData.setVisibility(View.VISIBLE);
                    cheDept.setVisibility(View.GONE);
                }else {

                    chenoData.setVisibility(View.GONE);
                   cheDept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1: snapshot.getChildren()){
                        TeacherData data= snapshot1.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    cheDept.setHasFixedSize(true);
                    cheDept.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter= new TeacherAdapter(list2, UpdateFaculty.this,"Chemistry");
                    cheDept.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void phyDept() {
        dbref = reference.child("Physics");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if(!snapshot.exists()){
                   phynoData.setVisibility(View.VISIBLE);
                   phyDept.setVisibility(View.GONE);
                }else {

                    phynoData.setVisibility(View.GONE);
                   phyDept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1: snapshot.getChildren()){
                        TeacherData data= snapshot1.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    phyDept.setHasFixedSize(true);
                    phyDept.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter= new TeacherAdapter(list3, UpdateFaculty.this,"Physics");
                    phyDept.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void  matDept() {
        dbref = reference.child("Mathematics");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if(!snapshot.exists()){
                    matnoData.setVisibility(View.VISIBLE);
                    matDept.setVisibility(View.GONE);
                }else {

                    matnoData.setVisibility(View.GONE);
                    matDept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1: snapshot.getChildren()){
                        TeacherData data= snapshot1.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    matDept.setHasFixedSize(true);
                    matDept.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter= new TeacherAdapter(list4, UpdateFaculty.this,"Mathematics");
                    matDept.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}
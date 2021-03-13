package com.sanjeet.cameraxapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sanjeet.cameraxapp.adapter.ImageAdapter;
import com.sanjeet.cameraxapp.model.ImageData;

import java.util.ArrayList;
import java.util.List;

import static com.sanjeet.cameraxapp.MainActivity.Database_Path;
/**
 * Created by SANJEET KUMAR on 23,February,2021, sk698166@gmail.com
 **/
public class ImageActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageAdapter imageAdapter;
    List<ImageData> imageDataArrayList;
    DatabaseReference databaseReference;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        recyclerView = findViewById(R.id.recycler);
        RecyclerView.LayoutManager l = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(l);
        progressDialog = new ProgressDialog(ImageActivity.this);
        imageDataArrayList = new ArrayList<>();
        progressDialog.setMessage("Loading Images From Firebase.");
        progressDialog.show();
        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                imageDataArrayList.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    ImageData imageUploadInfo = postSnapshot.getValue(ImageData.class);
                    imageDataArrayList.add(imageUploadInfo);
                    imageAdapter = new ImageAdapter(getApplicationContext(), imageDataArrayList);
                    recyclerView.setAdapter(imageAdapter);
                    imageAdapter.notifyDataSetChanged();
                    Log.e("===", "Image Data is A :" + imageDataArrayList);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressDialog.dismiss();
            }
        });
    }
}
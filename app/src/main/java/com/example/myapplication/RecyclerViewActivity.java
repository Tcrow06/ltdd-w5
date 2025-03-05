package com.example.myapplication;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.PhimAdapterRecyclerView;

import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView rvMoives;

    private PhimAdapterRecyclerView adapter;
    private List<Object> songList;
    private Button btnAddMovie;
    private Button btnAddActor;
    private int movieCount = 5;
    private int actorCount = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        EdgeToEdge.enable(this);
        setContentView(R.layout.gridview);

        btnAddMovie.findViewById(R.id.btnAddMovie);

    }
}

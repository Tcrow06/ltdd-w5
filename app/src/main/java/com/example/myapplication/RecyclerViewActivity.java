package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.PhimAdapterRecyclerView;
import com.example.myapplication.dto.DienVien;
import com.example.myapplication.dto.Phim;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView rvMoives;

    private PhimAdapterRecyclerView adapter;
    private List<Object> objects;
    private Button btnAddMovie;
    private Button btnAddActor;
    private int movieCount = 3;
    private int actorCount = 3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        EdgeToEdge.enable(this);
        setContentView(R.layout.recyclerview);

        btnAddMovie = findViewById(R.id.btnAddMovie);
        btnAddActor = findViewById(R.id.btnAddActor);
        rvMoives = findViewById(R.id.rv_recycler);


        objects = new ArrayList<>();
        objects.add(new Phim("P01", "Bùa Hình Nhân", "Kinh dị", "Phim được lấy cảm hứng từ loại bùa hình...",R.drawable.buahinhnhan));
        objects.add(new Phim("P02", "Đảo Hải Tặc", "Phiêu lưu", "Phim với chiếc mũ rơm và nhóm bạn đủ thành phần...",R.drawable.onepiece));
        objects.add(new Phim("P03", "Thế Giới Ma Quái 2", "Kinh dị", "Phim được lấy bối cảnh ở khu vực trại tị nạn...",R.drawable.maquai));

        objects.add(new DienVien("Cao Minh Đạt", "Nam", "1975",R.drawable.cmdat));
        objects.add(new DienVien("Đại Nghĩa", "Nam", "1978",R.drawable.dainghia2022));
        objects.add(new DienVien("Phương Anh Đào", "Nữ","1992" ,R.drawable.padao));



        adapter = new PhimAdapterRecyclerView(this, objects);
        rvMoives.setAdapter(adapter);
        rvMoives.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        btnAddMovie.setOnClickListener(b -> {
            movieCount++;
            Phim phimMoi = new Phim("P0"+movieCount, "Tên phim mới", "Loại phim mới", "Mô tả ngắn của phim mới ",R.drawable.onepiece);

            // Tìm vị trí cuối cùng của phim trong danh sách
            int lastMovieIndex = -1;
            for (int i = 0; i < objects.size(); i++) {
                if (objects.get(i) instanceof Phim) {
                    lastMovieIndex = i;
                }
            }

            int insertIndex = (lastMovieIndex == -1) ? 0 : lastMovieIndex + 1;
            objects.add(insertIndex, phimMoi);


            adapter.notifyItemInserted(movieCount - 1);
        });

        btnAddActor.setOnClickListener(b -> {
            actorCount++;
            DienVien dienVienMoi = new DienVien("Tên diễn viên mới", "Giới tính của diễn viên", "Năm sinh của diễn viên ",R.drawable.padao);
            objects.add(dienVienMoi);

            adapter.notifyItemInserted(objects.size() - 1);
        });

    }
}

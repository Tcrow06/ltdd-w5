package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.adapter.MonhocAdapterView;
import com.example.myapplication.dto.MonHoc;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    int selectedPosition = -1;
    ListView listView;
    ArrayList<MonHoc> arrayList;
    MonhocAdapterView adapter;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        EdgeToEdge.enable(this);
        setContentView(R.layout.listview);


        arrayList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);

        arrayList.add(new MonHoc("ReactJs", "ReactJs",R.drawable.react));
        arrayList.add(new MonHoc("Js", "Java Script",R.drawable.js));
        arrayList.add(new MonHoc("AngularJS", "AngularJS",R.drawable.angularjs));
        arrayList.add(new MonHoc("Java", "Java ",R.drawable.java));

        adapter = new MonhocAdapterView(ListViewActivity.this,R.layout.row_monhoc,arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> p, View v, int position, long id) {
                Toast.makeText(ListViewActivity.this, "Bạn đang chọn "+arrayList.get(position).getName(),
                        Toast.LENGTH_SHORT).show();
                EditText editTenMH = findViewById(R.id.editTenMH);
                editTenMH.setText(arrayList.get(position).getName());
                selectedPosition = position;
            }

        });

        Button btnThemMH = findViewById(R.id.btnThemMH);
        btnThemMH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTenMH = findViewById(R.id.editTenMH);
                String tenMonHoc = editTenMH.getText().toString().trim();
                if(selectedPosition==-1){
                    Toast.makeText(ListViewActivity.this, "Vui lòng chọn môn học để lấy mô tả và ảnh!", Toast.LENGTH_SHORT).show();
                }
                else if (!tenMonHoc.isEmpty()) {
                    String desc = arrayList.get(selectedPosition).getDesc();
                    int pic =  arrayList.get(selectedPosition).getPic();
                    arrayList.add(new MonHoc(tenMonHoc,desc,pic));

                    adapter.notifyDataSetChanged();

                    editTenMH.setText("");
                    Toast.makeText(ListViewActivity.this, "Đã thêm môn học!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(ListViewActivity.this, "Vui lòng nhập tên môn học!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btnCapNhatMH = findViewById(R.id.btnCapNhatMH);
        btnCapNhatMH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTenMH = findViewById(R.id.editTenMH);
                String tenMonHocMoi = editTenMH.getText().toString().trim();

                if (selectedPosition != -1 && !tenMonHocMoi.isEmpty()) {
                    arrayList.get(selectedPosition).setName(tenMonHocMoi);
                    adapter.notifyDataSetChanged();
                    editTenMH.setText("");
                    selectedPosition = -1;
                    Toast.makeText(ListViewActivity.this, "Đã thay đổi tên môn học", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(ListViewActivity.this, "Vui lòng chọn môn học để cập nhật!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayList.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(ListViewActivity.this, "Đã xóa môn học!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });


    }
}

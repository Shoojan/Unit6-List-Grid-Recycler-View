package com.example.unit5_demo.recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unit5_demo.R;

import java.util.List;

public class RecyclerTaskDetailActivity extends AppCompatActivity {

    RecyclerView taskDetailsRecyclerView;
    List<TaskDetail> taskDetailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_task_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recyclerView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        taskDetailsRecyclerView = findViewById(R.id.taskDetailsRecyclerView);

        // Retrieve task details from the intent
        List<TaskDetail> taskDetails = (List<TaskDetail>) getIntent().getSerializableExtra("TASK_DETAILS");

        //Initiate Recycler View using LinearLayoutManager and Custom Adapter
        taskDetailsRecyclerView.setLayoutManager(new GridLayoutManager(
                this,
                2));

        RecyclerTaskDetailAdapter adapter = new RecyclerTaskDetailAdapter(taskDetails);
        taskDetailsRecyclerView.setAdapter(adapter);

    }
}
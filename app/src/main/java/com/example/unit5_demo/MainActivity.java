package com.example.unit5_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.unit5_demo.gridview.GridTaskActivity;

public class MainActivity extends AppCompatActivity {


    Button taskBtn;
    ListView phasesListView;
    String[] phases = {"🤔 Planning", "😓 Design", "😷 Development", "🤨 Testing", "😁 Deployment", "🥲 Maintenance"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        taskBtn = findViewById(R.id.taskBtn);
        phasesListView = findViewById(R.id.phasesListView);

        //Initiate List View using simple Array Adapter


        taskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event and move to GridView
                Intent intent = new Intent(MainActivity.this, GridTaskActivity.class);
                startActivity(intent);
            }
        });
    }
}
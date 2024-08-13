package com.example.unit5_demo.gridview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.unit5_demo.R;
import com.example.unit5_demo.recyclerview.RecyclerTaskDetailActivity;
import com.example.unit5_demo.recyclerview.TaskDetail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GridTaskActivity extends AppCompatActivity {
    GridView tasksGridView;
    String[] tasks = {"💡 Brainstorm Ideas", "🖼️ Create Wireframes", "🎨 Design UI", "👨‍💻 Write Code", "🧪 Test Features", "🚀 Launch App"};

    // Task details for each task
    HashMap<String, List<TaskDetail>> taskDetailsMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.gridView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize task details for each task
        initializeTaskDetails();

        tasksGridView = findViewById(R.id.tasksGridView);

        //Initiate Grid View using simple Array Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        tasksGridView.setAdapter(adapter);

        tasksGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedTask = tasks[position];
                List<TaskDetail> taskDetails = taskDetailsMap.get(selectedTask);

                // Handle click event and move to RecyclerView
                Intent intent = new Intent(GridTaskActivity.this, RecyclerTaskDetailActivity.class);
                intent.putExtra("taskDetails", (Serializable) taskDetails);
                startActivity(intent);
            }
        });
    }

    private void initializeTaskDetails() {
        taskDetailsMap = new HashMap<>();

        for (int i = 0; i < tasks.length; i++) {
            List<TaskDetail> taskDetails = new ArrayList<>();

            if (i == 0) {
                taskDetails.add(new TaskDetail("Gather Team", true, "Schedule a meeting with all key stakeholders.", R.drawable.brainstorm_gather_team));
                taskDetails.add(new TaskDetail("Discuss App Concept", false, "Talk through the initial concept and goals.", R.drawable.brainstorm_team_discuss));
                taskDetails.add(new TaskDetail("List Ideas", false, "Write down all the brainstorming ideas.", R.drawable.brainstorm_team_list_ideas));
            } else if (i == 1) {
                taskDetails.add(new TaskDetail("Sketch UI Layout", true, "Create rough sketches of the app's UI.", R.drawable.wireframing_sketch_ui));
                taskDetails.add(new TaskDetail("Choose Tools", false, "Select tools like Figma or Sketch for wireframing.", R.drawable.wireframing_choose_tools));
                taskDetails.add(new TaskDetail("Design Wireframes", false, "Design detailed wireframes for all screens.", R.drawable.wireframing_design_wireframe));
            }
            // Add more task details for other tasks...

            taskDetailsMap.put(tasks[i], taskDetails);

        }
    }
}
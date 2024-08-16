package com.example.unit5_demo.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unit5_demo.R;

import java.util.List;

public class RecyclerTaskDetailAdapter
        extends RecyclerView.Adapter<RecyclerTaskDetailAdapter.TaskDetailHolder> {

    List<TaskDetail> taskDetails;

    public RecyclerTaskDetailAdapter(List<TaskDetail> taskDetails) {
        this.taskDetails = taskDetails;
    }

    @NonNull
    @Override
    public TaskDetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_task_detail_item, parent, false);
        return new TaskDetailHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskDetailHolder holder, int position) {
        TaskDetail taskDetail = taskDetails.get(position);
        holder.taskName.setText(taskDetail.getName());
        holder.taskCompleted.setChecked(taskDetail.isCompleted());
        holder.taskNote.setText(taskDetail.getNotes());
        holder.taskImage.setImageResource(taskDetail.getImage());
    }

    @Override
    public int getItemCount() {
        return taskDetails.size();
    }

    public class TaskDetailHolder extends RecyclerView.ViewHolder {
        private final TextView taskName;
        private final CheckBox taskCompleted;
        private final TextView taskNote;
        private final ImageView taskImage;

        public TaskDetailHolder(@NonNull View itemView) {
            super(itemView);

            taskName = itemView.findViewById(R.id.taskName);
            taskCompleted = itemView.findViewById(R.id.taskCompleted);
            taskNote = itemView.findViewById(R.id.taskNote);
            taskImage = itemView.findViewById(R.id.taskImage);
        }
    }
}

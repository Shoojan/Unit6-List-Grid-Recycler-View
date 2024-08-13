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

public class TaskDetailAdapter extends RecyclerView.Adapter<TaskDetailAdapter.TaskViewHolder> {

    private final List<TaskDetail> taskDetailList;

    public TaskDetailAdapter(List<TaskDetail> taskDetailList) {
        this.taskDetailList = taskDetailList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_task_detail_item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        TaskDetail taskDetail = taskDetailList.get(position);
        holder.taskName.setText(taskDetail.getName());
        holder.taskCompleted.setChecked(taskDetail.isCompleted());
        holder.taskNote.setText(taskDetail.getNotes());
        holder.taskImage.setImageResource(taskDetail.getImage());
    }

    @Override
    public int getItemCount() {
        return taskDetailList.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView taskName;
        CheckBox taskCompleted;
        TextView taskNote;
        ImageView taskImage;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            taskName = itemView.findViewById(R.id.taskName);
            taskCompleted = itemView.findViewById(R.id.taskCompleted);
            taskNote = itemView.findViewById(R.id.taskNote);
            taskImage = itemView.findViewById(R.id.taskImage);
        }
    }
}

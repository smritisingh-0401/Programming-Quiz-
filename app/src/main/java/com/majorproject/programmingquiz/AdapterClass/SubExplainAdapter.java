package com.majorproject.programmingquiz.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.majorproject.programmingquiz.Explain_Fragment;
import com.majorproject.programmingquiz.Quiz_Fragment;
import com.majorproject.programmingquiz.R;
import com.majorproject.programmingquiz.modelClass.ExplainModel;
import com.majorproject.programmingquiz.modelClass.SubModel;

import java.util.ArrayList;

public class SubExplainAdapter extends RecyclerView.Adapter<SubExplainAdapter.ViewHolder> {

    Context context;
    ArrayList<ExplainModel> list;

    public SubExplainAdapter(Context context, ArrayList<ExplainModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SubExplainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.explain_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubExplainAdapter.ViewHolder holder, int position) {
        ExplainModel model = list.get(position);
        holder.explain.setText(model.getTitle());
        holder.itemView.setOnClickListener(v->{
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper, new Explain_Fragment(model.getCategory(),model.getTitle())).addToBackStack(null).commit();

        });


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView explain;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            explain = itemView.findViewById(R.id.explain);
        }
    }
}

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView explain;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            explain = itemView.findViewById(R.id.explain);
        }
    }
    }

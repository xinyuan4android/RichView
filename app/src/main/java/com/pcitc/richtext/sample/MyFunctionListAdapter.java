package com.pcitc.richtext.sample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

/**
 * @author xinyu
 * @des 功能列表adapter
 * @time 2022/9/25 14:56
 */
public class MyFunctionListAdapter extends RecyclerView.Adapter<MyFunctionListAdapter.ViewHolder> {
    private final List<String> dataSource;
    private final MyOnItemClickListener onItemClickListener;

    public MyFunctionListAdapter(List<String> dataSource, MyOnItemClickListener onItemClickListener) {
        this.dataSource = dataSource;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_function_list, parent, false);
        return new ViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String itemBean = dataSource.get(position);
        holder.tvFunctionName.setText(itemBean);
    }

    @Override
    public int getItemCount() {
        if (dataSource != null) {
            return dataSource.size();
        }
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvFunctionName;
        MyOnItemClickListener itemClickListener;

        public ViewHolder(@NonNull View itemView, MyOnItemClickListener onItemClickListener) {
            super(itemView);
            this.itemClickListener = onItemClickListener;
            tvFunctionName = itemView.findViewById(R.id.tvFuctionName);
            tvFunctionName.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null) {
                itemClickListener.onFunctionItemClick(v, getAdapterPosition());
            }
        }
    }

    public interface MyOnItemClickListener {
        void onFunctionItemClick(View view, int position);
    }
}

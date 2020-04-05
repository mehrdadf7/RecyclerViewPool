package com.github.mehrdadf7.recyclerviewpool;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SubItemAdapter extends RecyclerView.Adapter<SubItemAdapter.SubItemViewHolder> {

    private List<SubItem> subItemList;

    public SubItemAdapter(List<SubItem> subItemList) {
        this.subItemList = subItemList;
    }

    @NonNull
    @Override
    public SubItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SubItemViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.layout_sub_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SubItemViewHolder holder, int position) {
        holder.bind(subItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return subItemList.size();
    }

    public class SubItemViewHolder extends RecyclerView.ViewHolder {

        private TextView subItemTitle, subItemDesc;

        public SubItemViewHolder(@NonNull View itemView) {
            super(itemView);
            subItemTitle = itemView.findViewById(R.id.tv_sub_item_title);
            subItemDesc = itemView.findViewById(R.id.tv_sub_item_desc);
        }

        public void bind(SubItem subItem) {
            subItemTitle.setText(subItem.getSunItemTitle());
            subItemDesc.setText(subItem.getSunItemDescription());
        }
    }

}

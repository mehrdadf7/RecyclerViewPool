package com.github.mehrdadf7.recyclerviewpool;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {


    private RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
    private List<Item> items;

    public ItemAdapter(List<Item> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(
                LayoutInflater
                    .from(parent.getContext())
                .inflate(R.layout.layout_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private RecyclerView rvSubItems;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            rvSubItems = itemView.findViewById(R.id.rv_sub_item);
        }

        public void bind(Item item) {

            tvTitle.setText(item.getItemTitle());

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                    rvSubItems.getContext(),
                    LinearLayoutManager.VERTICAL,
                    false
            );
            linearLayoutManager.setInitialPrefetchItemCount(item.getSubItemList().size());

            SubItemAdapter subItemAdapter = new SubItemAdapter(item.getSubItemList());

            rvSubItems.setLayoutManager(linearLayoutManager);
            rvSubItems.setAdapter(subItemAdapter);
            rvSubItems.setRecycledViewPool(recycledViewPool);

        }
    }
}

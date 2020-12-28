package com.example.android.utilitybillcalculator.classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.utilitybillcalculator.R;

import java.util.ArrayList;

//Adapter to be used with RecyclerView

public class SpendingAdapter extends RecyclerView.Adapter<SpendingAdapter.SpendingViewHolder> {
    private ArrayList<Spending> mSpendingList;

    public static class SpendingViewHolder extends RecyclerView.ViewHolder {
        public TextView spendingType;
        public TextView spendingName;
        public TextView spendingDate;
        public TextView spendingCost;

        public SpendingViewHolder(@NonNull View itemView) {
            super(itemView);
            spendingType = itemView.findViewById(R.id.list_spending_type);
            spendingName = itemView.findViewById(R.id.list_spending_name);
            spendingDate = itemView.findViewById(R.id.list_spending_date);
            spendingCost = itemView.findViewById(R.id.list_spending_cost);
        }
    }

    public SpendingAdapter(ArrayList<Spending> spendingList) {
        mSpendingList = spendingList;
    }

    @NonNull
    @Override
    public SpendingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        SpendingViewHolder spendingViewHolder = new SpendingViewHolder(v);
        return spendingViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SpendingViewHolder holder, int position) {
        Spending currentItem = mSpendingList.get(position);

        holder.spendingType.setText(currentItem.getType());
        holder.spendingName.setText(currentItem.getName());
        holder.spendingCost.setText(String.format("%.2f", currentItem.getCost()));
        holder.spendingDate.setText(currentItem.getDate());
    }

    @Override
    public int getItemCount() {
        return mSpendingList.size();
    }
}

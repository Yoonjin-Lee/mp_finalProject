package com.example.mp_final;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp_final.databinding.DataLayoutBinding;

import java.util.ArrayList;

public class DataRVAdapter extends RecyclerView.Adapter<DataRVAdapter.ViewHolder> {

    ArrayList<Data> dataArrayList;

    public DataRVAdapter(ArrayList<Data> dataArrayList) {
        this.dataArrayList = dataArrayList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        DataLayoutBinding viewBinding;
        public ViewHolder(DataLayoutBinding dataLayoutBinding){
            super(dataLayoutBinding.getRoot());
            this.viewBinding = dataLayoutBinding;
        }
        void bindData(Data data){
            Log.d("adapter", "bind");
            viewBinding.color.setBackgroundColor(data.color);
            viewBinding.col.setText(data.col.toString());
            viewBinding.row.setText(data.row.toString());
            viewBinding.height.setText(data.height.toString());
            viewBinding.name.setText(data.name);
            Log.d("adapter", "finish");
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DataLayoutBinding dataLayoutBinding = DataLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Log.d("adapter", "onCreateViewHolder");
        return new ViewHolder(dataLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("adapter", "before");
        holder.bindData(dataArrayList.get(position));
        Log.d("adapter", "onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }
}

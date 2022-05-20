package com.example.babycare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.babycare.db.User_Weight;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {

    private Context context;
    private List<User_Weight> userList;

    public UserListAdapter(Context context) {
        this.context = context;
    }

    public void setUserList(List<User_Weight> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.MyViewHolder holder, int position) {
        holder.tvageYear.setText(this.userList.get(position).ageYear);
        holder.tvageMonth.setText(this.userList.get(position).ageMonth);
        holder.tvWeight.setText(this.userList.get(position).weight);
    }

    @Override
    public int getItemCount() {
        return this.userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvageYear;
        TextView tvageMonth;
        TextView tvWeight;

        public MyViewHolder(View view) {
            super(view);
            tvageYear = view.findViewById(R.id.tvAgeY);
            tvageMonth = view.findViewById(R.id.tvAgeM);
            tvWeight = view.findViewById(R.id.tvWeight);

        }
    }
}

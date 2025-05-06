package com.example.examenprueba1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenprueba1.R;
import com.example.examenprueba1.listeners.UserListener;
import com.example.examenprueba1.models.UserModel;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    public List <UserModel> usersList;
    private UserListener userListener;

    public UserAdapter(List<UserModel> usersList, UserListener userListener)
    {
        this.usersList = usersList;
        this.userListener = userListener;
    }


    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater ly= LayoutInflater.from(parent.getContext());
        View v= ly.inflate(R.layout.item_user,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        UserModel user = usersList.get(holder.getAdapterPosition());
        holder.setdata(user);
        holder.data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userListener.OnClick(usersList.get(holder.getAdapterPosition()));
            }
        });


    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView gender, name, email;
        LinearLayout data;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gender = itemView.findViewById(R.id.gender);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            data = itemView.findViewById(R.id.userData);
        }

        public void setdata(UserModel user) {
            gender.setText(user.getGender());
            name.setText(user.getNameStr());
            email.setText(user.getEmail());

        }
    }

    public void update(List<UserModel> users)
    {
        usersList = users;
        notifyDataSetChanged();
    }
}

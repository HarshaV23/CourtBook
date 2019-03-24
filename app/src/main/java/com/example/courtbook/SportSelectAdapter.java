package com.example.courtbook;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SportSelectAdapter extends RecyclerView.Adapter<SportSelectAdapter.SportViewHolder> {
    private ArrayList<Getsport> msportlist;

    public static class SportViewHolder extends RecyclerView.ViewHolder{
        //public ImageView imageView;
        public RelativeLayout relativeLayout;
        public TextView textView;
        public SportViewHolder(@NonNull View itemView) {
            super(itemView);
          //  imageView=itemView.findViewById(R.id.sportImg);
            relativeLayout=itemView.findViewById(R.id.sportRelative);
            textView=itemView.findViewById(R.id.sportName);
        }
    }
    public SportSelectAdapter(ArrayList<Getsport>sportlist){
                msportlist=sportlist;
    }

    @NonNull
    @Override
    public SportViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sportcard,viewGroup,false);
        SportViewHolder evh=new SportViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull SportViewHolder sportViewHolder, int i) {
            Getsport current=msportlist.get(i);
            sportViewHolder.relativeLayout.setBackgroundResource(current.getSportimg());
            sportViewHolder.textView.setText(current.getSportname());
    }

    @Override
    public int getItemCount() {
        return msportlist.size();
    }
}

package com.example.courtbook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
    private Context context;


    public SportSelectAdapter(ArrayList<Getsport> sportlist, Context context){
                msportlist=sportlist;
                this.context = context;
    }

    @NonNull
    @Override
    public SportViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.sportcard, viewGroup, false);
        return new SportSelectAdapter.SportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SportViewHolder sportViewHolder, int i) {
            Getsport sport=msportlist.get(i);
            sportViewHolder.relativeLayout.setBackgroundResource(sport.getSportimg());
            sportViewHolder.textView.setText(sport.getSportname());
    }

    @Override
    public int getItemCount() {
        return msportlist.size();
    }

    public class SportViewHolder extends RecyclerView.ViewHolder{
        //public ImageView imageView;
        public RelativeLayout relativeLayout;
        public TextView textView;
        public SportViewHolder(@NonNull View itemView) {
            super(itemView);
            //  imageView=itemView.findViewById(R.id.sportImg);
            relativeLayout=itemView.findViewById(R.id.sportRelative);
            textView=itemView.findViewById(R.id.sportName);

            String sport=textView.getText().toString();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String sport=textView.getText().toString();
                    Selection.sport=sport;
                    Intent intent;
                    intent = new Intent(context,Court.class);
                    Activity activity=(Activity) context;
                    context.startActivity(intent);


                }
            });
        }
    }
}

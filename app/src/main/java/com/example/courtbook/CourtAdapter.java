package com.example.courtbook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CourtAdapter extends RecyclerView.Adapter<CourtAdapter.CourtViewHolder> {

            private ArrayList<Getcourt> mcourtlist;
            private Context context;

    public CourtAdapter(ArrayList<Getcourt> mcourtlist, Context context) {
        this.mcourtlist = mcourtlist;
        this.context = context;
    }

    @NonNull
    @Override
    public CourtViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.courtcard, viewGroup, false);
        return new CourtAdapter.CourtViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourtViewHolder courtViewHolder, int i) {
        Getcourt court=mcourtlist.get(i);
        courtViewHolder.textView1.setText(court.getCourtnm());
        courtViewHolder.textView2.setText(court.getCourtadd());
        courtViewHolder.relativeLayout.setBackgroundResource(court.getCourtimg());
    }

    @Override
    public int getItemCount() {
        return mcourtlist.size();
    }

    public static class CourtViewHolder extends RecyclerView.ViewHolder{
        public RelativeLayout relativeLayout;
        public TextView textView1,textView2;


        public CourtViewHolder(@NonNull View itemView) {
            super(itemView);

            relativeLayout=itemView.findViewById(R.id.courtRelative);
            textView1=itemView.findViewById(R.id.courtname);
            textView2=itemView.findViewById(R.id.courtaddress);
        }





    }
}

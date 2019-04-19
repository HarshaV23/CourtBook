package com.example.courtbook;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class CourtAdapter extends RecyclerView.Adapter<CourtAdapter.CourtViewHolder> {

            private ArrayList<Getcourt> mcourtlist;
            private static Context context;
            private static DatePickerDialog.OnDateSetListener mdateset;

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



        public CourtViewHolder(@NonNull final View itemView) {
            super(itemView);


            relativeLayout=itemView.findViewById(R.id.courtRelative);
            textView1=itemView.findViewById(R.id.courtname);
            textView2=itemView.findViewById(R.id.courtaddress);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String court=textView1.getText().toString();
                    Selection.court=court;

                    Calendar c=Calendar.getInstance();
                    int year=c.get(Calendar.YEAR);
                    int month=c.get(Calendar.MONTH);
                    int day=c.get(Calendar.DAY_OF_MONTH);
                    DatePickerDialog mdialog=new DatePickerDialog(context,android.R.style.Theme_Holo_Light_Dialog
                     ,mdateset,year,month,day);
                    mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    mdialog.show();
                }
            });
            mdateset=new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                }
            };


        }





    }


}

package com.speartech.altasicio.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.speartech.altasicio.Activity.AccountActivity;
import com.speartech.altasicio.Activity.ClaimActivity;
import com.speartech.altasicio.Activity.LeadActivity;
import com.speartech.altasicio.Activity.LeaveActivity;
import com.speartech.altasicio.Activity.PotentialActivity;
import com.speartech.altasicio.Activity.QuotesActivity;
import com.speartech.altasicio.Model.Recycleview_Model;
import com.speartech.altasicio.Activity.ProductCatalogueActivity;
import com.speartech.altasicio.R;
import com.speartech.altasicio.Activity.TimeSheetActivity;

import java.util.ArrayList;

public class Home_Menu_Recycleview extends RecyclerView.Adapter<Home_Menu_Recycleview.MyViewHolder> {

    private ArrayList<Recycleview_Model> dataSet;
    public Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        ImageView imageViewIcon;
        CardView cardview;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.menu_Title);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.menu_Image);
            this.cardview = (CardView) itemView.findViewById(R.id.cardview);
        }
    }

    public Home_Menu_Recycleview(Context context, ArrayList<Recycleview_Model> data) {
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crm_menu, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        ImageView imageView = holder.imageViewIcon;
        CardView card = holder.cardview;
        textViewName.setText(dataSet.get(listPosition).getName());
        imageView.setImageResource(dataSet.get(listPosition).getImage());

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = dataSet.get(listPosition).getName();

                if(title.equals("Leads")){
                    Intent intent = new Intent(context.getApplicationContext(), LeadActivity.class);
                    context.startActivity(intent);
                }else if(title.equals("Account")){
                    Intent intent = new Intent(context.getApplicationContext(), AccountActivity.class);
                    context.startActivity(intent);
                }
                else if(title.equals("Timesheet")){
                    Intent intent = new Intent(context.getApplicationContext(), TimeSheetActivity.class);
                    context.startActivity(intent);
                }else if(title.equals("Leave")){
                    Intent intent = new Intent(context.getApplicationContext(), LeaveActivity.class);
                    context.startActivity(intent);
                }else if(title.equals("Claims")){
                    Intent intent = new Intent(context.getApplicationContext(), ClaimActivity.class);
                    context.startActivity(intent);
                }

                else if(title.equals("Quotes")){
                    Intent intent = new Intent(context.getApplicationContext(), QuotesActivity.class);
                    context.startActivity(intent);
                }else if(title.equals("Potential")){
                    Intent intent = new Intent(context.getApplicationContext(), PotentialActivity.class);
                    context.startActivity(intent);
                }

                else if(title.equals("Product")){
                    Intent intent = new Intent(context.getApplicationContext(), ProductCatalogueActivity.class);
                    context.startActivity(intent);
                }else{

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

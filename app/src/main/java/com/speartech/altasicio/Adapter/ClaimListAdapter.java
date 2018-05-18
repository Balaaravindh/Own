package com.speartech.altasicio.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.speartech.altasicio.Model.ClaimListModel;
import com.speartech.altasicio.R;

import java.util.List;

public class ClaimListAdapter extends ArrayAdapter<ClaimListModel> {

    List<ClaimListModel> claimListModels;
    ViewHolder holder;
    ClaimListModel claimListModel;
    private Context context;

    public ClaimListAdapter(Context context, List<ClaimListModel> claimListModels) {
        super(context, R.layout.claim_history_single_list, claimListModels);
        this.context = context;
        this.claimListModels = claimListModels;
    }

    @Override
    public int getCount() {
        return claimListModels.size();
    }

    @Override
    public ClaimListModel getItem(int position) {
        return claimListModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.claim_history_single_list, null);

            holder = new ViewHolder();

            holder.claim_name_value = (TextView) convertView.findViewById(R.id.claim_name_value);
            holder.period_from_value = (TextView) convertView.findViewById(R.id.period_from_value);
            holder.period_to_value = (TextView) convertView.findViewById(R.id.period_to_value);
            holder.total_value = (TextView) convertView.findViewById(R.id.total_value);
            holder.status_value = (TextView) convertView.findViewById(R.id.status_value);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        claimListModel = getItem(position);

        holder.claim_name_value.setText(claimListModel.getClaim_emp_name());
        holder.period_from_value.setText(claimListModel.getClaim_from_date());
        holder.period_to_value.setText(claimListModel.getClaim_to_date());
        holder.total_value.setText(claimListModel.getClaim_total());

        if(claimListModel.getClaim_status().equals("Approved")){
            holder.status_value.setTextColor(Color.parseColor("#228B22"));
        }else{
            holder.status_value.setTextColor(Color.parseColor("#B22222"));
        }

        holder.status_value.setText(claimListModel.getClaim_status());

        return convertView;
    }

    private class ViewHolder {

        TextView claim_name_value, period_from_value, period_to_value, total_value, status_value;

    }



}

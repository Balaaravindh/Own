package com.speartech.altasicio.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.speartech.altasicio.Model.ApprovedLeaveModel;
import com.speartech.altasicio.R;
import java.util.List;

public class ApprovedLeaveListAdapter extends ArrayAdapter<ApprovedLeaveModel> {

    List<ApprovedLeaveModel> approved_leave_values;
    ViewHolder holder;
    ApprovedLeaveModel approvedLeaveModel;
    private Context context;

    public ApprovedLeaveListAdapter(Context context, List<ApprovedLeaveModel> approved_leave_values) {
        super(context, R.layout.time_sheet_single_item, approved_leave_values);
        this.context = context;
        this.approved_leave_values = approved_leave_values;
    }

    @Override
    public int getCount() {
        return approved_leave_values.size();
    }

    @Override
    public ApprovedLeaveModel getItem(int position) {
        return approved_leave_values.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.approved_leave_list_single, null);

            holder = new ViewHolder();

            holder.leave_name_value = (TextView) convertView.findViewById(R.id.leave_name_value);
            holder.leave_from_value = (TextView) convertView.findViewById(R.id.leave_from_value);
            holder.leave_to_value = (TextView) convertView.findViewById(R.id.leave_to_value);
            holder.leave_status_value = (TextView) convertView.findViewById(R.id.leave_status_value);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        approvedLeaveModel = getItem(position);

        holder.leave_name_value.setText(approvedLeaveModel.getLeave_name());
        holder.leave_from_value.setText(approvedLeaveModel.getLeave_from_date());
        holder.leave_to_value.setText(approvedLeaveModel.getLeave_to_date());

        if(approvedLeaveModel.getStatus().equals("Approved")){
            holder.leave_status_value.setTextColor(Color.parseColor("#228B22"));
        }else{
            holder.leave_status_value.setTextColor(Color.parseColor("#B22222"));
        }

        holder.leave_status_value.setText(approvedLeaveModel.getStatus());

        return convertView;
    }

    private class ViewHolder {

        TextView leave_name_value, leave_from_value, leave_to_value, leave_status_value;

    }

}

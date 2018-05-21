package com.speartech.altasicio.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.speartech.altasicio.Model.TimeSheetModel;
import com.speartech.altasicio.R;

import java.util.List;

public class TimeSheetAdapter extends ArrayAdapter<TimeSheetModel> {

    List<TimeSheetModel> time_sheet_values;
    ViewHolder holder;
    TimeSheetModel timeSheetModel;
    private Context context;

    public TimeSheetAdapter(Context context, List<TimeSheetModel> time_sheet_values) {
        super(context, R.layout.time_sheet_single_item, time_sheet_values);
        this.context = context;
        this.time_sheet_values = time_sheet_values;
    }

    @Override
    public int getCount() {
        return time_sheet_values.size();
    }

    @Override
    public TimeSheetModel getItem(int position) {
        return time_sheet_values.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.time_sheet_single_item, null);

            holder = new ViewHolder();

            holder.project_value = (TextView) convertView.findViewById(R.id.project_value);
            holder.lead_account_value = (TextView) convertView.findViewById(R.id.lead_account_value);
            holder.task_value = (TextView) convertView.findViewById(R.id.task_value);
            holder.hour_value = (TextView) convertView.findViewById(R.id.hour_value);
            holder.notes_value = (TextView) convertView.findViewById(R.id.notes_value);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        timeSheetModel = getItem(position);

        holder.project_value.setText(timeSheetModel.getProject_name());
        holder.lead_account_value.setText(timeSheetModel.getLead_account_name());
        holder.task_value.setText(timeSheetModel.getTask_name());
        holder.hour_value.setText(timeSheetModel.getHours_time() + " Hours");
        holder.notes_value.setText(timeSheetModel.getNotes());

        return convertView;
    }

    private class ViewHolder {

        TextView project_value, lead_account_value, task_value, hour_value, notes_value;

    }

}

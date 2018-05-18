package com.speartech.altasicio.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.speartech.altasicio.Adapter.ApprovedLeaveListAdapter;
import com.speartech.altasicio.Model.ApprovedLeaveModel;
import com.speartech.altasicio.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class LeaveActivity extends AppCompatActivity {

    ActionBar actionBar;
    RelativeLayout back;

    RelativeLayout apply_leave_layout, approved_leave_layout, leave_history_layout;
    RelativeLayout apply, history, approved;

    //Apply Leave
    RelativeLayout leave_type;
    Dialog dialog = null;
    ListView dialog_ListView;
    TextView alertTitle;
    TextView leave_type_text, from_date, to_date;

    String[] listItems_LeaveType = {
            "Sick Leave",
            "Casual Leave",
            "Privilege Leave"
    };

    RelativeLayout from, to;
    public static Calendar myCalendar = Calendar.getInstance();
    public static int date_value = 0;

    //Approved Leave List
    public static ArrayList<String> approved_Leave_name = new ArrayList<>();
    public static ArrayList<String> approved_Leave_from = new ArrayList<>();
    public static ArrayList<String> approved_Leave_to = new ArrayList<>();
    public static ArrayList<String> approved_Leave_status = new ArrayList<>();

    ListView approved_leave_list;
    ApprovedLeaveListAdapter approvedLeaveListAdapter;
    public static ArrayList<ApprovedLeaveModel> approved_list_data, history_leave_data;

    //Leave History List
    ListView leave_historylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave);

        //Hide Status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Hide Action Bar
        actionBar = getSupportActionBar();
        actionBar.hide();

        initilize();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Date Picker
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apply_leave_layout.setVisibility(View.VISIBLE);
                leave_history_layout.setVisibility(View.GONE);
                approved_leave_layout.setVisibility(View.GONE);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apply_leave_layout.setVisibility(View.GONE);
                leave_history_layout.setVisibility(View.VISIBLE);
                approved_leave_layout.setVisibility(View.GONE);
            }
        });

        approved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apply_leave_layout.setVisibility(View.GONE);
                leave_history_layout.setVisibility(View.GONE);
                approved_leave_layout.setVisibility(View.VISIBLE);
            }
        });

        leave_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogtext("Select a Leave Type", listItems_LeaveType, 0);
            }
        });

        from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_value = 0;
                new DatePickerDialog(LeaveActivity.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_value = 1;
                new DatePickerDialog(LeaveActivity.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        //Approved Leave List
        approved_Leave_name = new ArrayList<>();
        approved_Leave_name.add("Privilege Leave");
        approved_Leave_name.add("Privilege Leave");
        approved_Leave_name.add("Sick Leave");

        approved_Leave_from = new ArrayList<>();
        approved_Leave_from.add("01-05-2018");
        approved_Leave_from.add("09-05-2018");
        approved_Leave_from.add("15-05-2018");

        approved_Leave_to = new ArrayList<>();
        approved_Leave_to.add("01-05-2018");
        approved_Leave_to.add("09-05-2018");
        approved_Leave_to.add("15-05-2018");

        approved_Leave_status = new ArrayList<>();
        approved_Leave_status.add("Approved");
        approved_Leave_status.add("Approved");
        approved_Leave_status.add("Approved");

        approved_list_data = new ArrayList<ApprovedLeaveModel>();
        for (int i = 0; i < approved_Leave_name.size(); i++) {
            approved_list_data.add(new ApprovedLeaveModel(
                    approved_Leave_name.get(i),
                    approved_Leave_from.get(i),
                    approved_Leave_to.get(i),
                    approved_Leave_status.get(i)
            ));
        }

        approvedLeaveListAdapter = new ApprovedLeaveListAdapter(LeaveActivity.this, approved_list_data);
        approved_leave_list.setAdapter(approvedLeaveListAdapter);

        approved_Leave_status = new ArrayList<>();
        approved_Leave_status.add("Rejected");
        approved_Leave_status.add("Approved");
        approved_Leave_status.add("Rejected");

        history_leave_data = new ArrayList<ApprovedLeaveModel>();
        for (int i = 0; i < approved_Leave_name.size(); i++) {
            history_leave_data.add(new ApprovedLeaveModel(
                    approved_Leave_name.get(i),
                    approved_Leave_from.get(i),
                    approved_Leave_to.get(i),
                    approved_Leave_status.get(i)
            ));
        }
        approvedLeaveListAdapter = new ApprovedLeaveListAdapter(LeaveActivity.this, history_leave_data);
        leave_historylist.setAdapter(approvedLeaveListAdapter);
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        if(date_value == 1){
            to_date.setText(sdf.format(myCalendar.getTime()));
        }else{
            from_date.setText(sdf.format(myCalendar.getTime()));
        }
    }

    public void Dialogtext(String select_a_parent_account, String[] listItemsValue, int values) {

        dialog = new Dialog(LeaveActivity.this);
        dialog.setContentView(R.layout.alert_layout);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);

        alertTitle = (TextView) dialog.findViewById(R.id.title_Text);
        alertTitle.setText(select_a_parent_account);

        dialog_ListView = (ListView) dialog.findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(LeaveActivity.this, R.layout.alert_list_single, listItemsValue);
        dialog_ListView.setAdapter(adapter);

        dialog_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog.dismiss();
                leave_type_text.setText(parent.getItemAtPosition(position).toString());
            }
        });

        dialog.show();

    }

    public void initilize(){

        back = (RelativeLayout) findViewById(R.id.back);
        apply = (RelativeLayout) findViewById(R.id.apply);
        history = (RelativeLayout) findViewById(R.id.history);
        approved = (RelativeLayout) findViewById(R.id.approved);
        apply_leave_layout = (RelativeLayout) findViewById(R.id.apply_leave_layout);
        approved_leave_layout = (RelativeLayout) findViewById(R.id.approved_leave_layout);
        leave_history_layout = (RelativeLayout) findViewById(R.id.leave_history_layout);
        from = (RelativeLayout) findViewById(R.id.from);
        to = (RelativeLayout) findViewById(R.id.to);
        leave_type = (RelativeLayout) findViewById(R.id.leave_type);
        leave_type_text = (TextView) findViewById(R.id.leave_type_text);
        from_date = (TextView) findViewById(R.id.from_date);
        to_date = (TextView) findViewById(R.id.to_date);

        approved_leave_list = (ListView) findViewById(R.id.approved_leave_list);
        leave_historylist = (ListView) findViewById(R.id.leave_historylist);

    }

}

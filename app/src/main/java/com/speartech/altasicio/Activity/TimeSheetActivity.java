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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.speartech.altasicio.Adapter.TimeSheetAdapter;
import com.speartech.altasicio.Model.TimeSheetModel;
import com.speartech.altasicio.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class TimeSheetActivity extends AppCompatActivity {

    public static ActionBar actionBar;
    public static RelativeLayout back, search;

    public static RelativeLayout employee_select, from, to;
    public static TextView select_employee, from_date, to_date;

    public static Button submit_timesheet;

    public static Calendar myCalendar = Calendar.getInstance();
    public static int date_value = 0;

    public static ArrayList<String> project_name = new ArrayList<>();
    public static ArrayList<String> lead_account_name = new ArrayList<>();
    public static ArrayList<String> task_name = new ArrayList<>();
    public static ArrayList<String> hours_time = new ArrayList<>();
    public static ArrayList<String> notes = new ArrayList<>();

    public static ArrayList<TimeSheetModel> time_sheet_data;
    public static ListView time_sheet_record;
    public static TimeSheetAdapter timeSheetAdapter;

    //public static ProgressBar progressBar;

    Dialog dialog = null;
    ListView dialog_ListView;
    TextView alertTitle;

    String[] listItems_Employee = {
            "Doe,John",
            "Two,EMpTwo",
            "Client,test",
            "One,Emp",
            "Aravindh"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_sheet);

        //Hide Status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Hide Action Bar
        actionBar = getSupportActionBar();
        actionBar.hide();

        initilze();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        submit_timesheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timesheet_data_method();
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

        from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_value = 0;
                new DatePickerDialog(TimeSheetActivity.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_value = 1;
                new DatePickerDialog(TimeSheetActivity.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        employee_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogtext("Select a Employee", listItems_Employee, 0);
            }
        });

    }

    public void Dialogtext(String select_a_parent_account, String[] listItemsValue, int values) {

        dialog = new Dialog(TimeSheetActivity.this);
        dialog.setContentView(R.layout.alert_layout);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);

        final int ids = values;

        alertTitle = (TextView) dialog.findViewById(R.id.title_Text);
        alertTitle.setText(select_a_parent_account);

        dialog_ListView = (ListView) dialog.findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(TimeSheetActivity.this, R.layout.alert_list_single, listItemsValue);
        dialog_ListView.setAdapter(adapter);

        dialog_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                select_employee.setText(parent.getItemAtPosition(position).toString());
                dialog.dismiss();
            }
        });

        dialog.show();

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

    public void timesheet_data_method(){
        project_name = new ArrayList<>();
        project_name.add("Lorem Ipsum");
        project_name.add("Lorem Ipsum Why we use it");
        project_name.add("Lorem Ipsum Where does it come from");
        project_name.add("Lorem Ipsum Where can I get some");

        lead_account_name = new ArrayList<>();
        lead_account_name.add("Lead");
        lead_account_name.add("Account");
        lead_account_name.add("Account");
        lead_account_name.add("Lead");

        task_name = new ArrayList<>();
        task_name.add("Definition");
        task_name.add("Why");
        task_name.add("Where");
        task_name.add("Where");

        hours_time = new ArrayList<>();
        hours_time.add("3");
        hours_time.add("4");
        hours_time.add("5");
        hours_time.add("6");

        notes = new ArrayList<>();
        notes.add("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.");
        notes.add("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. ");
        notes.add("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.");
        notes.add("There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour");

        time_sheet_data = new ArrayList<TimeSheetModel>();
        for (int i = 0; i < project_name.size(); i++) {
            time_sheet_data.add(new TimeSheetModel(
                    project_name.get(i),
                    lead_account_name.get(i),
                    task_name.get(i),
                    hours_time.get(i),
                    notes.get(i)
            ));
        }

        timeSheetAdapter = new TimeSheetAdapter(TimeSheetActivity.this, time_sheet_data);
        time_sheet_record.setAdapter(timeSheetAdapter);
    }

    public void initilze(){

        back = (RelativeLayout) findViewById(R.id.back);
        search = (RelativeLayout) findViewById(R.id.search);

        submit_timesheet = (Button) findViewById(R.id.submit_timesheet);

        time_sheet_record = (ListView) findViewById(R.id.time_sheet_record);

        //progressBar = (ProgressBar) findViewById(R.id.progressBar);

        employee_select = (RelativeLayout) findViewById(R.id.employee_select);
        from = (RelativeLayout) findViewById(R.id.from);
        to = (RelativeLayout) findViewById(R.id.to);

        select_employee = (TextView) findViewById(R.id.select_employee);
        from_date = (TextView) findViewById(R.id.from_date);
        to_date = (TextView) findViewById(R.id.to_date);

    }

}

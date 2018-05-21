package com.speartech.altasicio.Activity;

import android.app.Dialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.speartech.altasicio.R;

public class AddTimesheetActivity extends AppCompatActivity {

    public static ActionBar actionBar;
    public static RelativeLayout back;

    public static String[] listItems_Select_Project = {
            "General",
            "Campagin",
            "Activity"
    };

    public static String[] listItems_Select_Task = {
            "Meeting",
            "Demo",
            "Installation"
    };

    public static Dialog dialog = null;
    public static ListView dialog_ListView;
    public static TextView alertTitle;

    public static RelativeLayout select_project, select_task, select_lead_account;
    public static TextView select_project_text, select_task_text, select_lead_account_text;

    public static RelativeLayout lead_alert, account_alert;
    public static ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_timesheet);

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

        select_project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogtext("Select Project", listItems_Select_Project, 0);
            }
        });

        select_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogtext("Select a Task", listItems_Select_Task, 1);
            }
        });

        select_lead_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(AddTimesheetActivity.this);
                dialog.setContentView(R.layout.alert_tab_layout);
                dialog.setCancelable(false);
                dialog.setCanceledOnTouchOutside(false);

                lead_alert = (RelativeLayout) dialog.findViewById(R.id.lead);
                account_alert = (RelativeLayout) dialog.findViewById(R.id.account);
                listview = (ListView) dialog.findViewById(R.id.listview);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddTimesheetActivity.this, R.layout.alert_list_single, listItems_Select_Task);
                listview.setAdapter(adapter);

                lead_alert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddTimesheetActivity.this, R.layout.alert_list_single, listItems_Select_Task);
                        listview.setAdapter(adapter);
                    }
                });

                account_alert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddTimesheetActivity.this, R.layout.alert_list_single, listItems_Select_Project);
                        listview.setAdapter(adapter);
                    }
                });

                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        dialog.dismiss();

                        select_lead_account_text.setText(parent.getItemAtPosition(position).toString());
                    }
                });


                dialog.show();
            }
        });

    }

    public void Dialogtext(String select_a_parent_account, String[] listItemsValue, int values) {

        dialog = new Dialog(AddTimesheetActivity.this);
        dialog.setContentView(R.layout.alert_layout);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        final int ids = values;

        alertTitle = (TextView) dialog.findViewById(R.id.title_Text);
        alertTitle.setText(select_a_parent_account);

        dialog_ListView = (ListView) dialog.findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddTimesheetActivity.this, R.layout.alert_list_single, listItemsValue);
        dialog_ListView.setAdapter(adapter);

        dialog_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog.dismiss();

                if (ids == 0){
                    select_project_text.setText(parent.getItemAtPosition(position).toString());
                }else if(ids == 1){
                    select_task_text.setText(parent.getItemAtPosition(position).toString());
                }
            }
        });

        dialog.show();

    }

    public void initilze(){

        back = (RelativeLayout) findViewById(R.id.back);

        select_project = (RelativeLayout) findViewById(R.id.select_project);
        select_task = (RelativeLayout) findViewById(R.id.select_task);
        select_lead_account = (RelativeLayout) findViewById(R.id.select_lead_account);

        select_project_text =(TextView) findViewById(R.id.select_project_text);
        select_task_text =(TextView) findViewById(R.id.select_task_text);
        select_lead_account_text = (TextView) findViewById(R.id.select_lead_account_text);

    }

}

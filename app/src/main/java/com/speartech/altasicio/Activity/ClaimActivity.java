package com.speartech.altasicio.Activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.speartech.altasicio.Adapter.ClaimListAdapter;
import com.speartech.altasicio.Model.ClaimListModel;
import com.speartech.altasicio.R;

import java.util.ArrayList;

public class ClaimActivity extends AppCompatActivity {

    public static ActionBar actionBar;
    public static RelativeLayout back, submit;

    public static RelativeLayout apply, history, approved;
    public static RelativeLayout apply_claim_layout, history_claim_layout, approved_claim_layout;

    public static ListView claim_history, claim_approved;

    public static ArrayList<String> approved_Claim_Employee = new ArrayList<>();
    public static ArrayList<String> approved_Claim_period_from = new ArrayList<>();
    public static ArrayList<String> approved_Claim_period_to = new ArrayList<>();
    public static ArrayList<String> approved_Claim_total = new ArrayList<>();
    public static ArrayList<String> approved_Claim_status = new ArrayList<>();

    public static ClaimListAdapter claimListAdapter;
    public static ArrayList<ClaimListModel> claimListModels_approved, claimListModels_history;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_claim);

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

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apply_claim_layout.setVisibility(View.VISIBLE);
                submit.setVisibility(View.VISIBLE);

                approved_claim_layout.setVisibility(View.GONE);
                history_claim_layout.setVisibility(View.GONE);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history_claim_layout.setVisibility(View.VISIBLE);

                approved_claim_layout.setVisibility(View.GONE);
                apply_claim_layout.setVisibility(View.GONE);
                submit.setVisibility(View.GONE);
            }
        });

        approved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                approved_claim_layout.setVisibility(View.VISIBLE);

                history_claim_layout.setVisibility(View.GONE);
                apply_claim_layout.setVisibility(View.GONE);
                submit.setVisibility(View.GONE);
            }
        });

        //Approved Leave List
        approved_Claim_Employee = new ArrayList<>();
        approved_Claim_Employee.add("Aravind J");
        approved_Claim_Employee.add("Jahan G");
        approved_Claim_Employee.add("Arun Raj A");

        approved_Claim_period_from = new ArrayList<>();
        approved_Claim_period_from.add("01-05-2018");
        approved_Claim_period_from.add("09-05-2018");
        approved_Claim_period_from.add("15-05-2018");

        approved_Claim_period_to = new ArrayList<>();
        approved_Claim_period_to.add("01-05-2018");
        approved_Claim_period_to.add("09-05-2018");
        approved_Claim_period_to.add("15-05-2018");

        approved_Claim_total = new ArrayList<>();
        approved_Claim_total.add("1400");
        approved_Claim_total.add("2400");
        approved_Claim_total.add("1800");

        approved_Claim_status = new ArrayList<>();
        approved_Claim_status.add("Approved");
        approved_Claim_status.add("Approved");
        approved_Claim_status.add("Approved");


        claimListModels_approved = new ArrayList<ClaimListModel>();
        for (int i = 0; i < approved_Claim_Employee.size(); i++) {
            claimListModels_approved.add(new ClaimListModel(
                    approved_Claim_Employee.get(i),
                    approved_Claim_period_from.get(i),
                    approved_Claim_period_to.get(i),
                    approved_Claim_total.get(i),
                    approved_Claim_status.get(i)
            ));
        }

        claimListAdapter = new ClaimListAdapter(ClaimActivity.this, claimListModels_approved);
        claim_approved.setAdapter(claimListAdapter);

        approved_Claim_status = new ArrayList<>();
        approved_Claim_status.add("Rejected");
        approved_Claim_status.add("Approved");
        approved_Claim_status.add("Rejected");

        claimListModels_history = new ArrayList<ClaimListModel>();
        for (int i = 0; i < approved_Claim_Employee.size(); i++) {
            claimListModels_history.add(new ClaimListModel(
                    approved_Claim_Employee.get(i),
                    approved_Claim_period_from.get(i),
                    approved_Claim_period_to.get(i),
                    approved_Claim_total.get(i),
                    approved_Claim_status.get(i)
            ));
        }
        claimListAdapter = new ClaimListAdapter(ClaimActivity.this, claimListModels_history);
        claim_history.setAdapter(claimListAdapter);

    }

    public void initilize() {

        back = (RelativeLayout) findViewById(R.id.back);
        submit =(RelativeLayout) findViewById(R.id.submit);

        apply = (RelativeLayout) findViewById(R.id.apply);
        history = (RelativeLayout) findViewById(R.id.history);
        approved = (RelativeLayout) findViewById(R.id.approved);

        apply_claim_layout = (RelativeLayout) findViewById(R.id.apply_claim_layout);
        history_claim_layout = (RelativeLayout) findViewById(R.id.history_claim_layout);
        approved_claim_layout = (RelativeLayout) findViewById(R.id.approved_claim_layout);

        claim_history = (ListView) findViewById(R.id.claim_history_list);
        claim_approved = (ListView) findViewById(R.id.claim_approved_list);

    }

}

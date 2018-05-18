package com.speartech.altasicio.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.speartech.altasicio.Adapter.Home_Menu_Recycleview;
import com.speartech.altasicio.Model.Recycleview_Model;
import com.speartech.altasicio.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ActionBar actionBar;
    public static RelativeLayout logout;

    public static RelativeLayout activities, todo, alert, myprofile;

    public static RecyclerView.Adapter adapter;
    public static RecyclerView.LayoutManager layoutManager;
    public static ArrayList<Recycleview_Model> data;

    //CRM
    public static ArrayList<String> crm_Titles = new ArrayList<>();
    public static Integer[] crm_drawableArray = {R.mipmap.lead_blue, R.mipmap.account_blue};
    public static Integer[] crm_id_ = {0, 1};

    //HCM
    public static ArrayList<String> hcm_Titles = new ArrayList<>();
    public static Integer[] hcm_drawableArray = {R.mipmap.timesheet_blue, R.mipmap.leave_blue, R.mipmap.claim_blue};
    public static Integer[] hcm_id_ = {0, 1, 2};

    //Sales
    public static ArrayList<String> sales_Titles = new ArrayList<>();
    public static Integer[] sales_drawableArray = {R.mipmap.remainder_blue, R.mipmap.qoute_blue, R.mipmap.potential_blue};
    public static Integer[] sales_id_ = {0, 1, 2};

    //Tracking
    public static ArrayList<String> project_Titles = new ArrayList<>();
    public static Integer[] project_drawableArray = {R.mipmap.tracking_blue};
    public static Integer[] project_id_ = {0};

    //Inventory
    public static ArrayList<String> inventory_Titles = new ArrayList<>();
    public static Integer[] inventory_drawableArray = {R.mipmap.stock_blue, R.mipmap.source_blue, R.mipmap.product_blue};
    public static Integer[] inventory_id_ = {0, 1, 2};

    public static RecyclerView crm_menus_recyclerView, hcm_menus_recyclerView, sales_menus_recyclerView, project_menus_recyclerView, inventory_menus_recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hide Status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Hide Action Bar
        actionBar = getSupportActionBar();
        actionBar.hide();

        initilize();

        //CRM
        crm_menus_recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        crm_menus_recyclerView.setLayoutManager(layoutManager);
        crm_menus_recyclerView.setItemAnimator(new DefaultItemAnimator());

        crm_Titles = new ArrayList<>();
        crm_Titles.add("Leads");
        crm_Titles.add("Account");

        data = new ArrayList<Recycleview_Model>();
        for (int i = 0; i < crm_Titles.size(); i++) {
            data.add(new Recycleview_Model(
                    crm_Titles.get(i),
                    crm_id_[i],
                    crm_drawableArray[i]
            ));
        }
        adapter = new Home_Menu_Recycleview(MainActivity.this, data);
        crm_menus_recyclerView.setAdapter(adapter);

        //HCM
        hcm_menus_recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        hcm_menus_recyclerView.setLayoutManager(layoutManager);
        hcm_menus_recyclerView.setItemAnimator(new DefaultItemAnimator());

        hcm_Titles = new ArrayList<>();
        hcm_Titles.add("Timesheet");
        hcm_Titles.add("Leave");
        hcm_Titles.add("Claims");

        data = new ArrayList<Recycleview_Model>();
        for (int i = 0; i < hcm_Titles.size(); i++) {
            data.add(new Recycleview_Model(
                    hcm_Titles.get(i),
                    hcm_id_[i],
                    hcm_drawableArray[i]
            ));
        }
        adapter = new Home_Menu_Recycleview(MainActivity.this, data);
        hcm_menus_recyclerView.setAdapter(adapter);


        //Sales
        sales_menus_recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        sales_menus_recyclerView.setLayoutManager(layoutManager);
        sales_menus_recyclerView.setItemAnimator(new DefaultItemAnimator());

        sales_Titles = new ArrayList<>();
        sales_Titles.add("Remainder");
        sales_Titles.add("Quotes");
        sales_Titles.add("Potential");

        data = new ArrayList<Recycleview_Model>();
        for (int i = 0; i < sales_Titles.size(); i++) {
            data.add(new Recycleview_Model(
                    sales_Titles.get(i),
                    sales_id_[i],
                    sales_drawableArray[i]
            ));
        }
        adapter = new Home_Menu_Recycleview(MainActivity.this, data);
        sales_menus_recyclerView.setAdapter(adapter);

        //Project
        project_menus_recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        project_menus_recyclerView.setLayoutManager(layoutManager);
        project_menus_recyclerView.setItemAnimator(new DefaultItemAnimator());

        project_Titles = new ArrayList<>();
        project_Titles.add("Tracking");

        data = new ArrayList<Recycleview_Model>();
        for (int i = 0; i < project_Titles.size(); i++) {
            data.add(new Recycleview_Model(
                    project_Titles.get(i),
                    project_id_[i],
                    project_drawableArray[i]
            ));
        }
        adapter = new Home_Menu_Recycleview(MainActivity.this, data);
        project_menus_recyclerView.setAdapter(adapter);

        //Project
        inventory_menus_recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        inventory_menus_recyclerView.setLayoutManager(layoutManager);
        inventory_menus_recyclerView.setItemAnimator(new DefaultItemAnimator());

        inventory_Titles = new ArrayList<>();
        inventory_Titles.add("Stock");
        inventory_Titles.add("Sourcing");
        inventory_Titles.add("Product");

        data = new ArrayList<Recycleview_Model>();
        for (int i = 0; i < inventory_Titles.size(); i++) {
            data.add(new Recycleview_Model(
                    inventory_Titles.get(i),
                    inventory_id_[i],
                    inventory_drawableArray[i]
            ));
        }
        adapter = new Home_Menu_Recycleview(MainActivity.this, data);
        inventory_menus_recyclerView.setAdapter(adapter);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyProfileActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void initilize(){
        logout = (RelativeLayout) findViewById(R.id.logout);

        crm_menus_recyclerView = (RecyclerView) findViewById(R.id.crm_menus);
        hcm_menus_recyclerView = (RecyclerView) findViewById(R.id.hcm_menus);
        sales_menus_recyclerView = (RecyclerView) findViewById(R.id.sales_menus);
        project_menus_recyclerView = (RecyclerView) findViewById(R.id.project_menus);
        inventory_menus_recyclerView = (RecyclerView) findViewById(R.id.inventory_menus);

        activities = (RelativeLayout) findViewById(R.id.activities);
        todo = (RelativeLayout) findViewById(R.id.todo);
        alert = (RelativeLayout) findViewById(R.id.alert);
        myprofile = (RelativeLayout) findViewById(R.id.myprofile);

    }

}

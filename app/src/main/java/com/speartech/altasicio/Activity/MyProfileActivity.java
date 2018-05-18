package com.speartech.altasicio.Activity;

import android.app.Dialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.speartech.altasicio.R;

public class MyProfileActivity extends AppCompatActivity {

    ActionBar actionBar;
    RelativeLayout back;

    RelativeLayout edit_image, edit_image_tick;
    TextView profile_name;
    EditText edit_profile_name;

    ImageView profile_image;

    TextView setup_value;
    Dialog dialog = null;
    ListView dialog_ListView;
    TextView alertTitle;
    String[] listItems_weekday = {
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

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

        edit_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile_name.setVisibility(View.GONE);
                edit_profile_name.setVisibility(View.VISIBLE);

                edit_image_tick.setVisibility(View.VISIBLE);
                edit_image.setVisibility(View.GONE);
            }
        });

        edit_image_tick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_profile_name.setVisibility(View.GONE);
                profile_name.setVisibility(View.VISIBLE);

                edit_image.setVisibility(View.VISIBLE);
                edit_image_tick.setVisibility(View.GONE);

                profile_name.setText(edit_profile_name.getText().toString().trim());

            }
        });

        setup_value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogtext("Select a Setup Week Day", listItems_weekday, 0);
            }
        });

        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    public void Dialogtext(String select_a_parent_account, String[] listItemsValue, int values) {

        dialog = new Dialog(MyProfileActivity.this);
        dialog.setContentView(R.layout.alert_layout);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);

        alertTitle = (TextView) dialog.findViewById(R.id.title_Text);
        alertTitle.setText(select_a_parent_account);

        dialog_ListView = (ListView) dialog.findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MyProfileActivity.this, R.layout.alert_list_single, listItemsValue);
        dialog_ListView.setAdapter(adapter);

        dialog_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog.dismiss();
                setup_value.setText(parent.getItemAtPosition(position).toString());
            }
        });

        dialog.show();

    }

    public void initilze(){

        back = (RelativeLayout) findViewById(R.id.back);
        edit_image = (RelativeLayout) findViewById(R.id.edit_image);
        edit_image_tick = (RelativeLayout) findViewById(R.id.edit_image_tick);

        profile_name = (TextView) findViewById(R.id.profile_name);
        setup_value = (TextView) findViewById(R.id.setup_value);

        edit_profile_name = (EditText) findViewById(R.id.edit_profile_name);

        profile_image = (ImageView) findViewById(R.id.profile_image);

    }

}

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

public class LeadActivity extends AppCompatActivity {

    ActionBar actionBar;
    RelativeLayout back, submit;

    RelativeLayout parent_account, ownership, industry, nature_of_bussiness, lead_status, lead_source, rating, prospect;
    TextView parent_account_text, ownership_text, industry_text, nature_of_bussiness_text, lead_status_text, lead_source_text, rating_text, prospect_text;

    String[] listItems_parent_account = {
            "Account",
            "Lead1",
            "Acc1",
            "Sample Account 1",
            "Account Test",
            "TTT"
    };

    String[] listItems_ownership = {
            "Government",
            "Public",
            "Private",
            "Subsidary"
    };

    String[] listItems_industry = {
            "Education",
            "Engineering",
            "Facilities Management",
            "Finance",
            "FMCG",
            "Government",
            "Healthcare",
            "Hospitality / Travel",
            "Infrastrucure",
            "Large Corporations",
            "Logistics",
            "Manufacturing",
            "Media / Advertising / PR",
            "Professional Services",
            "Real Estate",
            "Services",
            "Small / Medium Enterprise",
            "Software",
            "Telecom"
    };

    String[] listItems_Nature_of_Business = {
            "Business1"
    };

    String[] listItems_Lead_Status = {
            "Active",
            "Acquired",
            "Pre Qualified",
            "Attempted to Contact",
            "Not Contacted",
            "Contact in future",
            "Market Failed",
            "Lost Lead"
    };

    String[] listItems_Lead_Source = {
            "Advertisement",
            "Cold Call",
            "Employee Referal",
            "External Referal",
            "Online",
            "Partner",
            "Public Relations",
            "Sales Mail",
            "Seminar Partner",
            "Seminar Internal",
            "Trade Show",
            "Database",
            "Campaign"
    };

    String[] listItems_Rating = {
            "1",
            "2",
            "3",
            "4",
            "5"
    };

    String[] listItems_Prospect = {
            "HOT",
            "WARM",
            "COLD"
    };

    Dialog dialog = null;
    ListView dialog_ListView;
    TextView alertTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead);

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

        parent_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogtext("Select a Parent Account", listItems_parent_account, 0);
            }
        });

        ownership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogtext("Select a Ownership", listItems_ownership, 1);
            }
        });

        industry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogtext("Select a Industry", listItems_industry, 2);
            }
        });

        nature_of_bussiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogtext("Select a Nature of Business", listItems_Nature_of_Business, 3);
            }
        });

        lead_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogtext("Select a Lead Status", listItems_Lead_Status, 4);
            }
        });

        lead_source.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogtext("Select a Lead Source", listItems_Lead_Source, 5);
            }
        });

        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogtext("Select a Rating", listItems_Rating, 6);
            }
        });

        prospect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogtext("Select a Rating", listItems_Prospect, 7);
            }
        });

    }

    public void Dialogtext(String select_a_parent_account, String[] listItemsValue, int values) {

        dialog = new Dialog(LeadActivity.this);
        dialog.setContentView(R.layout.alert_layout);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);

        final int ids = values;

        alertTitle = (TextView) dialog.findViewById(R.id.title_Text);
        alertTitle.setText(select_a_parent_account);

        dialog_ListView = (ListView) dialog.findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(LeadActivity.this, R.layout.alert_list_single, listItemsValue);
        dialog_ListView.setAdapter(adapter);

        dialog_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog.dismiss();
                if (ids == 0) {
                    parent_account_text.setText(parent.getItemAtPosition(position).toString());
                } else if(ids == 1){
                    ownership_text.setText(parent.getItemAtPosition(position).toString());
                } else if(ids == 2){
                    industry_text.setText(parent.getItemAtPosition(position).toString());
                } else if(ids == 3){
                    nature_of_bussiness_text.setText(parent.getItemAtPosition(position).toString());
                } else if(ids == 4){
                    lead_status_text.setText(parent.getItemAtPosition(position).toString());
                } else if(ids == 5){
                    lead_source_text.setText(parent.getItemAtPosition(position).toString());
                } else if(ids == 6){
                    rating_text.setText(parent.getItemAtPosition(position).toString());
                } else if(ids == 7){
                    prospect_text.setText(parent.getItemAtPosition(position).toString());
                }
            }
        });

        dialog.show();

    }

    public void initilze() {
        back = (RelativeLayout) findViewById(R.id.back);
        submit = (RelativeLayout) findViewById(R.id.submit);

        parent_account = (RelativeLayout) findViewById(R.id.parent_account);
        ownership = (RelativeLayout) findViewById(R.id.ownership);
        industry = (RelativeLayout) findViewById(R.id.industry);
        nature_of_bussiness = (RelativeLayout) findViewById(R.id.nature_of_bussiness);
        lead_status = (RelativeLayout) findViewById(R.id.lead_status);
        lead_source = (RelativeLayout) findViewById(R.id.lead_source);
        rating = (RelativeLayout) findViewById(R.id.rating);
        prospect = (RelativeLayout) findViewById(R.id.prospect);

        parent_account_text = (TextView) findViewById(R.id.parent_account_text);
        ownership_text = (TextView) findViewById(R.id.ownership_text);
        industry_text = (TextView) findViewById(R.id.industry_text);
        nature_of_bussiness_text = (TextView) findViewById(R.id.nature_of_bussiness_text);
        lead_status_text = (TextView) findViewById(R.id.lead_status_text);
        lead_source_text = (TextView) findViewById(R.id.lead_source_text);
        rating_text = (TextView) findViewById(R.id.rating_text);
        prospect_text = (TextView) findViewById(R.id.prospect_text);
    }

}

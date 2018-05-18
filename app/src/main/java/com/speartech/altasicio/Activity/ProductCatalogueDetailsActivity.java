package com.speartech.altasicio.Activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.speartech.altasicio.R;

public class ProductCatalogueDetailsActivity extends AppCompatActivity {

    public static ActionBar actionBar;
    public static RelativeLayout back;

    public static String title, category, supplier, cost;

    public static TextView product_title,product_code, product_title_name, product_category, product_supplier, product_cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_catalogue_details);

        //Hide Status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Hide Action Bar
        actionBar = getSupportActionBar();
        actionBar.hide();

        initilize();

        title = getIntent().getStringExtra("title");
        category = getIntent().getStringExtra("category");
        supplier = getIntent().getStringExtra("supplier");
        cost = getIntent().getStringExtra("base_cost");

        product_title.setText(title);
        product_code.setText(title.substring(10).replace(")","").replace("(", ""));
        product_title_name.setText(title);
        product_category.setText(category);
        product_supplier.setText(supplier);
        product_cost.setText("\u20B9 " + cost);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void initilize(){

        back = (RelativeLayout) findViewById(R.id.back);

        product_title = (TextView) findViewById(R.id.title);
        product_code = (TextView) findViewById(R.id.product_code_value);
        product_title_name = (TextView) findViewById(R.id.product_name_value);
        product_category = (TextView) findViewById(R.id.product_category_value);
        product_supplier = (TextView) findViewById(R.id.product_supplier_value);
        product_cost = (TextView) findViewById(R.id.product_cost_value);

    }
}

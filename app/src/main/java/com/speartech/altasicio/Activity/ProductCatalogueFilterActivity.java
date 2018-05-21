package com.speartech.altasicio.Activity;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.speartech.altasicio.Adapter.ProductCatalogueFilterAdapter;
import com.speartech.altasicio.Model.ProductCatalogueFilterModel;
import com.speartech.altasicio.R;

import java.util.ArrayList;

public class ProductCatalogueFilterActivity extends AppCompatActivity {

    ActionBar actionBar;
    RelativeLayout back;

    public static RelativeLayout apply, cancel;

    ListView product_catalogue_filter;
    public static ArrayList<String> filter_titles = new ArrayList<>();
    public static ArrayList<ProductCatalogueFilterModel> productCatalogueFilterModels;
    public static ProductCatalogueFilterAdapter productCatalogueFilterAdapter;

    public static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_catalogue_filter);

        //Hide Status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Hide Action Bar
        actionBar = getSupportActionBar();
        actionBar.hide();

        activity = ProductCatalogueFilterActivity.this;

        initilze();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        filter_titles.add("A");
        filter_titles.add("B");
        filter_titles.add("C");
        filter_titles.add("D");
        filter_titles.add("E");
        filter_titles.add("F");
        filter_titles.add("G");
        filter_titles.add("H");
        filter_titles.add("I");
        filter_titles.add("J");
        filter_titles.add("K");
        filter_titles.add("L");
        filter_titles.add("M");
        filter_titles.add("N");
        filter_titles.add("O");
        filter_titles.add("P");
        filter_titles.add("Q");
        filter_titles.add("R");
        filter_titles.add("S");
        filter_titles.add("T");
        filter_titles.add("U");
        filter_titles.add("V");
        filter_titles.add("W");
        filter_titles.add("X");
        filter_titles.add("Y");
        filter_titles.add("Z");

        productCatalogueFilterModels = new ArrayList<ProductCatalogueFilterModel>();
        for (int i = 0; i < filter_titles.size(); i++) {
            productCatalogueFilterModels.add(new ProductCatalogueFilterModel(
                    filter_titles.get(i)
            ));
        }

        productCatalogueFilterAdapter = new ProductCatalogueFilterAdapter(ProductCatalogueFilterActivity.this, productCatalogueFilterModels);
        product_catalogue_filter.setAdapter(productCatalogueFilterAdapter);

    }

    public void initilze(){

        back = (RelativeLayout) findViewById(R.id.back);

        apply = (RelativeLayout) findViewById(R.id.apply);
        cancel = (RelativeLayout) findViewById(R.id.cancel);

        product_catalogue_filter = (ListView) findViewById(R.id.product_catalogue_filter);

    }

    public static void close_method() {
        activity.finish();
    }

}

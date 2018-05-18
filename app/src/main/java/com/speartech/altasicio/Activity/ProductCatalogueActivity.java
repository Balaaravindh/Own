package com.speartech.altasicio.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.speartech.altasicio.Adapter.ProductCatalogueAdapter;
import com.speartech.altasicio.Model.ProductCatalogueModel;
import com.speartech.altasicio.R;

import java.util.ArrayList;

public class ProductCatalogueActivity extends AppCompatActivity {

    public static ActionBar actionBar;
    public static RelativeLayout back;

    public static ArrayList<String> product_name = new ArrayList<>();
    public static ArrayList<String> product_category = new ArrayList<>();
    public static ArrayList<String> product_supplier = new ArrayList<>();
    public static ArrayList<String> product_base_cost = new ArrayList<>();

    public static ArrayList<ProductCatalogueModel> productCatalogueModels;
    public static ListView product_catalogue_list;
    public static ProductCatalogueAdapter productCatalogueAdapter;

    public static RelativeLayout filter, all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_catalogue);

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

        product_name = new ArrayList<>();
        product_name.add("Product01 (P001)");
        product_name.add("Product02 (P002)");
        product_name.add("Product03 (P003)");

        product_category = new ArrayList<>();
        product_category.add("Category 01");
        product_category.add("Engine Values");
        product_category.add("Category 02");

        product_supplier = new ArrayList<>();
        product_supplier.add("Sample");
        product_supplier.add("Sample");
        product_supplier.add("Sample");

        product_base_cost = new ArrayList<>();
        product_base_cost.add("5000");
        product_base_cost.add("10000");
        product_base_cost.add("15000");

        productCatalogueModels = new ArrayList<ProductCatalogueModel>();
        for (int i = 0; i < product_name.size(); i++) {
            productCatalogueModels.add(new ProductCatalogueModel(
                    product_name.get(i),
                    product_category.get(i),
                    product_supplier.get(i),
                    product_base_cost.get(i)
            ));
        }

        productCatalogueAdapter = new ProductCatalogueAdapter(ProductCatalogueActivity.this, productCatalogueModels);
        product_catalogue_list.setAdapter(productCatalogueAdapter);

        product_catalogue_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ProductCatalogueActivity.this, ProductCatalogueDetailsActivity.class);
                intent.putExtra("title", productCatalogueModels.get(position).getProduct_name());
                intent.putExtra("category", productCatalogueModels.get(position).getProduct_category());
                intent.putExtra("supplier", productCatalogueModels.get(position).getProduct_supplier());
                intent.putExtra("base_cost", productCatalogueModels.get(position).getProduct_base_cost());
                startActivity(intent);
            }
        });

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCatalogueActivity.this, ProductCatalogueFilterActivity.class);
                startActivity(intent);
            }
        });

    }

    public void initilze(){
        back = (RelativeLayout) findViewById(R.id.back);

        product_catalogue_list = (ListView) findViewById(R.id.product_catalogue);

        filter = (RelativeLayout) findViewById(R.id.filter);
        all = (RelativeLayout) findViewById(R.id.all);
    }

}

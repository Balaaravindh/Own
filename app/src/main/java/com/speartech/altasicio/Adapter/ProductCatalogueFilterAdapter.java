package com.speartech.altasicio.Adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import com.speartech.altasicio.Model.ProductCatalogueFilterModel;
import com.speartech.altasicio.Activity.ProductCatalogueFilterActivity;
import com.speartech.altasicio.R;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalogueFilterAdapter extends ArrayAdapter<ProductCatalogueFilterModel> {

    List<ProductCatalogueFilterModel> productCatalogueFilterModels;
    ViewHolder holder;
    ProductCatalogueFilterModel productCatalogueFilterModel;
    private Context context;
    private boolean[] thumbnailsselection;
    private int count;

    public ProductCatalogueFilterAdapter(Context context, List<ProductCatalogueFilterModel> productCatalogueFilterModels) {
        super(context, R.layout.product_catalogue_filter, productCatalogueFilterModels);
        this.context = context;
        this.productCatalogueFilterModels = productCatalogueFilterModels;

        count = productCatalogueFilterModels.size();
        thumbnailsselection = new boolean[count];
    }

    public int getCount() {
        return productCatalogueFilterModels.size();
    }

    @Override
    public ProductCatalogueFilterModel getItem(int position) {
        return productCatalogueFilterModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.product_catalogue_filter, null);

            holder = new ViewHolder();

            holder.filter_title = (CheckBox) convertView.findViewById(R.id.filter_checkbox);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        productCatalogueFilterModel = getItem(position);

        holder.filter_title.setText(productCatalogueFilterModel.getFilter_title());
        holder.filter_title.setId(position);

        holder.filter_title.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                CheckBox cb = (CheckBox) v;
                int id = cb.getId();
                if (thumbnailsselection[id]) {
                    cb.setChecked(false);
                    thumbnailsselection[id] = false;
                } else {
                    cb.setChecked(true);
                    thumbnailsselection[id] = true;
                }
            }
        });

        ProductCatalogueFilterActivity.apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ArrayList<String> posSel = new ArrayList<String>();
                posSel.clear();
                for (int i = 0; i < thumbnailsselection.length; i++) {
                    if (thumbnailsselection[i] == true) {
                        posSel.add(productCatalogueFilterModels.get(i).getFilter_title());
                        Log.e("string", productCatalogueFilterModels.get(i).getFilter_title());
                    }
                }
            }
        });

        ProductCatalogueFilterActivity.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductCatalogueFilterActivity.close_method();
            }
        });

        return convertView;
    }

    private class ViewHolder {

        CheckBox filter_title;

    }


}

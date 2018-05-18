package com.speartech.altasicio.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.speartech.altasicio.Model.ProductCatalogueModel;
import com.speartech.altasicio.Model.TimeSheetModel;
import com.speartech.altasicio.R;

import java.util.List;

public class ProductCatalogueAdapter extends ArrayAdapter<ProductCatalogueModel> {

    List<ProductCatalogueModel> productCatalogueModels;
    ViewHolder holder;
    ProductCatalogueModel productCatalogueModel;
    private Context context;

    public ProductCatalogueAdapter(Context context, List<ProductCatalogueModel> productCatalogueModels) {
        super(context, R.layout.product_catalogue_single_, productCatalogueModels);
        this.context = context;
        this.productCatalogueModels = productCatalogueModels;
    }

    @Override
    public int getCount() {
        return productCatalogueModels.size();
    }

    @Override
    public ProductCatalogueModel getItem(int position) {
        return productCatalogueModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.product_catalogue_single_, null);

            holder = new ViewHolder();

            holder.product_name = (TextView) convertView.findViewById(R.id.product_catalogure_title);
            holder.product_category = (TextView) convertView.findViewById(R.id.product_catalogure_category_value);
            holder.product_supplier = (TextView) convertView.findViewById(R.id.product_catalogure_supplier_value);
            holder.product_base_cost = (TextView) convertView.findViewById(R.id.product_catalogure_base_cost_value);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        productCatalogueModel = getItem(position);

        holder.product_name.setText(productCatalogueModel.getProduct_name());
        holder.product_category.setText(productCatalogueModel.getProduct_category());
        holder.product_supplier.setText(productCatalogueModel.getProduct_supplier());
        holder.product_base_cost.setText("\u20B9 " + productCatalogueModel.getProduct_base_cost());

        return convertView;
    }

    private class ViewHolder {

        TextView product_name, product_category, product_supplier, product_base_cost;

    }


}

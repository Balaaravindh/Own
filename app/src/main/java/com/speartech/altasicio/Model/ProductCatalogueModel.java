package com.speartech.altasicio.Model;

public class ProductCatalogueModel {

    String product_name;
    String product_category;
    String product_supplier;
    String product_base_cost;

    public ProductCatalogueModel(String product_name, String product_category, String product_supplier, String product_base_cost) {
        this.product_name = product_name;
        this.product_category = product_category;
        this.product_supplier = product_supplier;
        this.product_base_cost = product_base_cost;
    }

    public String getProduct_category() {
        return product_category;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_supplier() {
        return product_supplier;
    }

    public String getProduct_base_cost() {
        return product_base_cost;
    }
}

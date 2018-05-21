package com.speartech.altasicio.Model;

public class ClaimListModel {

    String claim_emp_name;
    String claim_from_date;
    String claim_to_date;
    String claim_total;
    String claim_status;

    public ClaimListModel(String claim_emp_name, String claim_from_date, String claim_to_date, String claim_total, String claim_status) {
        this.claim_emp_name = claim_emp_name;
        this.claim_from_date = claim_from_date;
        this.claim_to_date = claim_to_date;
        this.claim_total = claim_total;
        this.claim_status = claim_status;
    }

    public String getClaim_emp_name() {
        return claim_emp_name;
    }

    public String getClaim_from_date() {
        return claim_from_date;
    }

    public String getClaim_status() {
        return claim_status;
    }

    public String getClaim_to_date() {
        return claim_to_date;
    }

    public String getClaim_total() {
        return claim_total;
    }


}

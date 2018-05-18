package com.speartech.altasicio.Model;

public class ApprovedLeaveModel {

    String leave_name;
    String leave_from_date;
    String leave_to_date;
    String status;

    public ApprovedLeaveModel(String leave_name, String leave_from_date, String leave_to_date, String status) {
        this.leave_name = leave_name;
        this.leave_from_date = leave_from_date;
        this.leave_to_date = leave_to_date;
        this.status = status;
    }

    public String getLeave_from_date() {
        return leave_from_date;
    }

    public String getLeave_name() {
        return leave_name;
    }

    public String getLeave_to_date() {
        return leave_to_date;
    }

    public String getStatus() {
        return status;
    }

}

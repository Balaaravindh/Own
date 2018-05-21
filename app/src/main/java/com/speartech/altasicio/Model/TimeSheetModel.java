package com.speartech.altasicio.Model;

public class TimeSheetModel {

    String project_name;
    String lead_account_name;
    String task_name;
    String hours_time;
    String notes;

    public TimeSheetModel(String project_name, String lead_account_name, String task_name, String hours_time, String notes) {
        this.project_name = project_name;
        this.lead_account_name = lead_account_name;
        this.task_name = task_name;
        this.hours_time = hours_time;
        this.notes = notes;
    }

    public String getHours_time() {
        return hours_time;
    }

    public String getLead_account_name() {
        return lead_account_name;
    }

    public String getNotes() {
        return notes;
    }

    public String getProject_name() {
        return project_name;
    }

    public String getTask_name() {
        return task_name;
    }

}

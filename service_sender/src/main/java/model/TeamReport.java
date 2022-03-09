package model;

import java.util.Date;
import java.util.List;

public class TeamReport {
    private Date date;
    private String teamName;
    private List<Report> reports;

    public TeamReport() {}

    public TeamReport(Date date, String teamName, List<Report> reports) {
        this.date = date;
        this.teamName = teamName;
        this.reports = reports;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    @Override
    public String toString() {
        return "Report{" +
                "date = " + date +
                ", teamName = " + teamName +
                ", reports = '" + reports +
                '}';
    }
}

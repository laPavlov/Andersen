package model;

import java.util.Date;

public class ServiceAccountantDTO {

    private long id;
    private Date date;
    private int time;
    private String task;
    private Long userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ServiceAccountantDTO{" +
                "id=" + id +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", task='" + task + '\'' +
                ", userId=" + userId +
                '}';
    }
}

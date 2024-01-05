package com.referatapi.app.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private int creator; // Maybe User instead of int
    @Column(name = "closed_by")
    private Integer closedBy; // Maybe User instead of int
    private int assignee; // Maybe User instead of int
    private String status;
    private String priority;
    @Column(name = "created_at")
    private String createdAt; // time
    private String deadline; // time

    //private Tag tags;

    public Ticket(int id, String title, String description, int creator, Integer closedBy, int asignee, String status, String priority, String createdAt, String deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.closedBy = closedBy;
        this.assignee = asignee;
        this.status = status;
        this.priority = priority;
        this.createdAt = createdAt;
        this.deadline = deadline;
    }

    public Ticket(String title, String description, int creator, Integer closedBy, int asignee, String status, String priority, String createdAt, String deadline) {
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.closedBy = closedBy;
        this.assignee = asignee;
        this.status = status;
        this.priority = priority;
        this.createdAt = createdAt;
        this.deadline = deadline;
    }

    public Ticket() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public Integer getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(Integer closedBy) {
        this.closedBy = closedBy;
    }

    public int getAssignee() {
        return assignee;
    }

    public void setAssignee(int asignee) {
        this.assignee = asignee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

}

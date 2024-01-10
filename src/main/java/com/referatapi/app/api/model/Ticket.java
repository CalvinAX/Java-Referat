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
    @ManyToOne
    @JoinColumn(name = "creator")
    private User creator;
    @ManyToOne
    @JoinColumn(name = "closed_by") // Hier wird der Fremdschlüssel definiert
    private User closedBy;
    @ManyToOne
    @JoinColumn(name = "assignee")
    private User assignee;
    private String status;
    private String priority;
    @Column(name = "created_at")
    private String createdAt; // time
    private String deadline; // time

    public Ticket(int id, String title, String description, User creator, User closedBy, User assignee, String status, String priority, String createdAt, String deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.closedBy = closedBy;
        this.assignee = assignee;
        this.status = status;
        this.priority = priority;
        this.createdAt = createdAt;
        this.deadline = deadline;
    }

    public Ticket(String title, String description, User creator, User closedBy, User assignee, String status, String priority, String createdAt, String deadline) {
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.closedBy = closedBy;
        this.assignee = assignee;
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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(User closedBy) {
        this.closedBy = closedBy;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
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
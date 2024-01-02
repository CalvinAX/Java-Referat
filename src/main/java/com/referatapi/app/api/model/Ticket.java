package com.referatapi.app.api.model;

import jakarta.persistence.*;

import java.util.Optional;

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
    private int asignee; // Maybe User instead of int
    private String status;
    private String priority;
    //private Tag tags;

    public Ticket(int id, String title, String description, int creator, Integer closedBy, int asignee, String status, String priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.closedBy = closedBy;
        this.asignee = asignee;
        this.status = status;
        this.priority = priority;
    }

    public Ticket(String title, String description, int creator, Integer closedBy, int asignee, String status, String priority) {
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.closedBy = closedBy;
        this.asignee = asignee;
        this.status = status;
        this.priority = priority;
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

    public int getAsignee() {
        return asignee;
    }

    public void setAsignee(int asignee) {
        this.asignee = asignee;
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

}

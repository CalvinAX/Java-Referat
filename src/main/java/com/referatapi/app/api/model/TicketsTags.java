package com.referatapi.app.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets_tags")
public class TicketsTags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Ticket ticket_id;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag_id;

    /**
     *
     * @param id int
     * @param ticket_id int
     * @param tag_id int
     */
    public TicketsTags(int id, Ticket ticket_id, Tag tag_id) {
        this.id = id;
        this.ticket_id = ticket_id;
        this.tag_id = tag_id;
    }

    /**
     *
     * @param ticket_id int
     * @param tag_id int
     */
    public TicketsTags(Ticket ticket_id, Tag tag_id) {
        this.ticket_id = ticket_id;
        this.tag_id = tag_id;
    }

    /**
     * Leerer Konstruktor
     */
    public TicketsTags() {

    }

    public int getId() {
        return id;
    }

    public Ticket getTicket_id() {
        return ticket_id;
    }

    public Tag getTag_id() {
        return tag_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTicket_id(Ticket ticket_id) {
        this.ticket_id = ticket_id;
    }

    public void setTag_id(Tag tag_id) {
        this.tag_id = tag_id;
    }
}

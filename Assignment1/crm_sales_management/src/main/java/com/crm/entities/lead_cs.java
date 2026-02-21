package com.crm.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "lead_cs")
public class lead_cs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadid;

    private String source;
    private String status;

    @OneToOne(mappedBy = "leadid")
    private Customer customer;

    public Long getLeadid() { return leadid; }
    public void setLeadid(Long leadid) { this.leadid = leadid; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
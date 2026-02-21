package com.crm.entities;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name;
    private String email;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lead_id")
    private lead_cs leadid;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orderlist;

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public lead_cs getLeadid() { return leadid; }
    public void setLeadid(lead_cs leadid) { this.leadid = leadid; }

    public List<Order> getOrderlist() { return orderlist; }
    public void setOrderlist(List<Order> orderlist) { this.orderlist = orderlist; }
}
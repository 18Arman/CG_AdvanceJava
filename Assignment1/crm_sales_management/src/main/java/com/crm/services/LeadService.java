package com.crm.services;

import org.hibernate.Session;

import com.crm.config.HibernateUtil;
import com.crm.entities.lead_cs;

public class LeadService {

    public void getLeadById(Long id) {

        Session session = HibernateUtil.getSession();

        lead_cs lead = session.get(lead_cs.class, id);

        if (lead == null) {
            System.out.println("Lead Not Found");
            session.close();
            return;
        }

        System.out.println("Lead ID: " + lead.getLeadid());
        System.out.println("Source: " + lead.getSource());
        System.out.println("Status: " + lead.getStatus());

        session.close();
    }
}
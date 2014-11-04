/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polimi.se2.addressbook.gui;

import it.polimi.se2.addressbook.boundary.ContactFacade;
import it.polimi.se2.addressbook.entity.Contact;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;

/**
 *
 * @author miglie
 */
@Model
public class ContactBean {
    
    @EJB ContactFacade cf;

    private Contact current;
    
    public ContactBean() {
    }

    public void setCurrent(Contact current) {
        this.current = current;
    }

    public Contact getCurrent() {
        if (current==null) {
            current = new Contact();
        }
        return current;
    }
    
    public void create() {
        cf.create(current);
    }
    
    public int getCount() {
        return cf.count();
    }
    
}

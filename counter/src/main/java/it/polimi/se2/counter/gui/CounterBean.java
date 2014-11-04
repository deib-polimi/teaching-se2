/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polimi.se2.counter.gui;

import it.polimi.se2.counter.business.CounterService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author miglie
 */
@Named(value = "counter")
@SessionScoped
public class CounterBean implements Serializable{

    @EJB
    CounterService cs;

    public CounterBean() {
    }

    public int getCount() {
        return cs.getCount();
    }

    public void plusOne() {
        cs.plusOne();
    }
}

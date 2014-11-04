/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polimi.se2.counter.business;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

/**
 *
 * @author miglie
 */
@Stateful
public class CounterService {

    private int count = 0;
    
    public void plusOne() {
        count+=1;
    }

    public int getCount() {
        return count;
    }
    
    @PostConstruct
    public void constructed() {
        System.out.println("CounterService constructed");
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polimi.se2.calculator.business;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

/**
 *
 * @author miglie
 */
@Stateful
public class CalculatorService {
    
    @PostConstruct
    void constructed() {
        System.out.println("CalculatorService constructed!");
    }

    public int add(int x, int y) {
        return x+y;
    }
}

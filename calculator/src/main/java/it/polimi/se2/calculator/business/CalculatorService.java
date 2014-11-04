/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polimi.se2.calculator.business;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 *
 * @author miglie
 */
@Stateless
public class CalculatorService {
    
    @PostConstruct
    void constructed() {
        System.out.println("CalculatorService constructed!");
    }

    public double add(double x, double y) {
        return x+y;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polimi.se2.calculator.gui;

import it.polimi.se2.calculator.business.CalculatorService;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;

/**
 *
 * @author miglie
 */
@Model
public class CalculatorBean {

    @EJB
    CalculatorService cs;

    private double x, y, result;

    public void add() {
        result = cs.add(x, y);
    }

    public CalculatorBean() {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

}

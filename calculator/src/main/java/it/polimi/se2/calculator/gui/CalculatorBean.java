/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polimi.se2.calculator.gui;

import it.polimi.se2.calculator.business.CalculatorService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Named;

/**
 *
 * @author miglie
 */
@Named
@RequestScoped
public class CalculatorBean {

    @EJB
    CalculatorService cs;

    private int x, y, result;

    public void add() {
        result = cs.add(x, y);
    }

    public CalculatorBean() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

}

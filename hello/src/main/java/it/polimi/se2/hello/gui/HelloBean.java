/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polimi.se2.hello.gui;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author miglie
 */
@Named
@RequestScoped
public class HelloBean {

    /**
     * Creates a new instance of HelloBean
     */
    public HelloBean() {
    }
    
    public String getMessage() {
        return "Hello World!";
    }
    
}

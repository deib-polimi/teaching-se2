/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polimi.se2.welcomeme.gui;

import java.io.Serializable;
import javax.enterprise.inject.Model;

/**
 *
 * @author miglie
 */
@Model
public class UserBean implements Serializable{

    private String name;
    
    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
}

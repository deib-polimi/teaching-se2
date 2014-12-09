/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polimi.creditcardvault.business.vault.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author miglie
 */
@Entity
public class CreditCard {
    
    
    @Id
    private String number;

    public CreditCard() {
    }

    public CreditCard(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
 
    
}

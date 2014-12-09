/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polimi.creditcardvault.business.vault.boundary;

import it.polimi.creditcardvault.business.vault.control.CreditCardChecker;
import it.polimi.creditcardvault.business.vault.entity.CreditCard;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author miglie
 */
@Stateless
public class SecureVaultService {

    @Inject
    CreditCardChecker ccChecker;
    
    @PersistenceContext
    EntityManager em;  
    
    public void store(CreditCard card) throws InvalidCreditCardNumberException {
        if (ccChecker.isValid(card)) {
           em.persist(card);
        } else {
           throw new InvalidCreditCardNumberException();
        }
    }
    
    
}

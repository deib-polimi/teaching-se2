/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polimi.creditcardvault.business.vault.boundary;

import it.polimi.creditcardvault.business.vault.control.CreditCardChecker;
import it.polimi.creditcardvault.business.vault.entity.CreditCard;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author miglie
 */
public class SecureVaultServiceTest {
    
    private SecureVaultService cut;
    
    @Before
    public void setUp() {
        cut = new SecureVaultService();
        cut.ccChecker = mock(CreditCardChecker.class);
        cut.em = mock(EntityManager.class);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test(expected = InvalidCreditCardNumberException.class)
    public void SecureVaultShouldNotStoreInvalidCards() throws InvalidCreditCardNumberException {
        CreditCard cc = new CreditCard("123");
        when(cut.ccChecker.isValid(cc)).thenReturn(Boolean.FALSE);
        try {
            cut.store(cc);
        } catch (InvalidCreditCardNumberException ex) {
            verify(cut.em, times(0)).persist(cc);
            throw ex;
        }
    }
    
    @Test
    public void SecureVaultShouldStoreValidCards() throws InvalidCreditCardNumberException {
        CreditCard cc = new CreditCard("123");
        when(cut.ccChecker.isValid(cc)).thenReturn(Boolean.TRUE);
        cut.store(cc);
        verify(cut.em,times(1)).persist(cc);
    }
}

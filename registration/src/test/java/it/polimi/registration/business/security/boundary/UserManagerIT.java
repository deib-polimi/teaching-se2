/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polimi.registration.business.security.boundary;

import it.polimi.registration.business.security.control.PasswordEncrypter;
import it.polimi.registration.business.security.entity.User;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author miglie
 */
@RunWith(Arquillian.class)
public class UserManagerIT {
    

    @EJB
    UserManager cut;
    
    @PersistenceContext
    EntityManager em;
    
//    @PersistenceContext
//    EntityManager em;

    @Deployment
    public static WebArchive createArchiveAndDeploy() {
        return ShrinkWrap.create(WebArchive.class)
                .addClass(UserManager.class)
                .addPackage(User.class.getPackage())
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
   
    @Test
    public void UserManagerShouldBeInjected() {
        assertNotNull(cut);
    }
    
    @Test
    public void EntityManagerShouldBeInjected() {
        assertNotNull(em);
    }

    @Test
    public void newUsersShouldBeValid() {
        User newUser = new User();
        newUser.setEmail("invalidemail");
        try {
            cut.save(newUser);
        } catch (Exception e) {
            assertTrue(e.getCause() instanceof ConstraintViolationException);
        }
        assertNull(em.find(User.class, "invalidemail"));
    }
    
    @Test
    public void passwordsShouldBeEncryptedOnDB() {
        User newUser = new User();
        String email = "marco@polimi.com";
        String password = "password";
        newUser.setEmail(email);
        newUser.setName("Marco");
        newUser.setPassword(password);
        cut.save(newUser);
        User foundUser = em.find(User.class, email);
        assertNotNull(foundUser);
        assertThat(foundUser.getPassword(),is(PasswordEncrypter.encryptPassword(password)));
    }

}

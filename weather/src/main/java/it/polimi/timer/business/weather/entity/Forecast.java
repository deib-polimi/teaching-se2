/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polimi.timer.business.weather.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author miglie
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Forecast implements Serializable {
    
    private String result;

    public Forecast() {
    }
      
    public Forecast(String result) {
        this.result = result;
    }    

    public String getResult() {
        return result;
    }
    
    
    
}

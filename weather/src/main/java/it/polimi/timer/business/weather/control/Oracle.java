/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polimi.timer.business.weather.control;

import it.polimi.timer.business.weather.entity.Forecast;

/**
 *
 * @author miglie
 */
public class Oracle {
    
    public Forecast getForecast(){
        return new Forecast("sunny");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polimi.timer.business.weather.boundary;

import it.polimi.timer.business.weather.entity.Forecast;
import it.polimi.timer.business.weather.control.Oracle;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author miglie
 */
@Stateless
public class WeatherService {

    @Inject
    Oracle oracle;
    
    public Forecast getForecast() {
        return oracle.getForecast();
    }
}

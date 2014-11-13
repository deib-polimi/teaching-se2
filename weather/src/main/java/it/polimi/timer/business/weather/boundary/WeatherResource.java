/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polimi.timer.business.weather.boundary;

import it.polimi.timer.business.weather.entity.Forecast;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author miglie
 * 
 * 
 * Protocol Adapter
 */
@Path("forecast")
public class WeatherResource {

    
    @Inject 
    WeatherService ws;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Forecast forecast() {
        return ws.getForecast();
    }
}

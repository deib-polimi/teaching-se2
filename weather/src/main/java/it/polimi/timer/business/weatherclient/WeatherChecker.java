/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.polimi.timer.business.weatherclient;

import it.polimi.timer.business.weather.entity.Forecast;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author miglie
 */
@Startup
@Singleton
public class WeatherChecker {

    private static final Logger logger = Logger.getLogger(WeatherChecker.class.getName());
    
    private Client client;
    
    @Resource
    private TimerService timerService;
    
    @PostConstruct
    private void init() {
        logger.log(Level.INFO, "WeatherChecker created");
        client = ClientBuilder.newClient();
        
        ScheduleExpression every5Seconds = new ScheduleExpression().second("*/5").minute("*").hour("*");
        timerService.createCalendarTimer(every5Seconds, new TimerConfig("", false));
    }

    @Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
    public void checkWeatherAutoTimer() {
        logger.log(Level.INFO, "{0}: automatic timer expired, checking the weather", new Date());
        Forecast forecast = client.target("http://localhost:8080/weather/rest/forecast")
                .request(MediaType.APPLICATION_JSON)
                .get(Forecast.class);
        logger.log(Level.INFO, "[auto] Oracle says: {0}", forecast.getResult());
    }
    
    @Timeout
    public void checkWeatherProgTimer(){
        logger.log(Level.INFO, "{0}: programmatic timer expired, checking the weather", new Date());
        Forecast forecast = client.target("http://localhost:8080/weather/rest/forecast")
                .request(MediaType.APPLICATION_JSON)
                .get(Forecast.class);
        logger.log(Level.INFO, "[prog] Oracle says: {0}", forecast.getResult());
    }

}

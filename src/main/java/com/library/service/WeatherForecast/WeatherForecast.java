package com.library.service.WeatherForecast;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by ���� on 08.01.2016.
 */
public interface WeatherForecast {
    void getWeatherForecast(HttpServletRequest request) throws IOException;
}

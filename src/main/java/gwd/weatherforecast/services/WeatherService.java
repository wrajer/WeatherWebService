package gwd.weatherforecast.services;

import gwd.weatherforecast.model.WeatherModel;
import org.springframework.web.client.RestTemplate;

public class WeatherService {


    public String getTemp(String city) {


        if (city != null) {
            String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=ef2028e98b54649bf1f4c4582631f350";
            RestTemplate restTemplate = new RestTemplate();
            WeatherModel weatherModel = restTemplate.getForObject(url, WeatherModel.class);

            //return    Double.toString(weatherModel.getMain().getTempinCelsium());
            return String.format("Temp in " + city + " is currently %.2f", weatherModel.getMain().getTempinCelsium());

        } else return null;
    }
}

//    if (city != null) {
//            String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=ef2028e98b54649bf1f4c4582631f350";
//            RestTemplate restTemplate = new RestTemplate();
//            WeatherModel weatherModel = restTemplate.getForObject(url, WeatherModel.class);
//        modelMap.put("weatherf", weatherModel.getMain().getTemp());
//        //   modelMap.put("weatherc", weatherModel.getMain().getTempinCelsium());
//        return
//        }

package gwd.weatherforecast;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {

    @ResponseBody //działa tak samo jak response bady i nie daje nam htmla
    @GetMapping("/")
    public String index () {
        //dajemy link do naszego API
        String url = "http://api.openweathermap.org/data/2.5/weather?q=Warszawa&appid=ef2028e98b54649bf1f4c4582631f350";

        //on ma sobie mapować automatycznie, Jasona na obiek jaki chcemy, na odstawie Jsona wybraliśmy chcemy maina
        RestTemplate restTemplate = new RestTemplate();

        WeatherModel weatherModel = restTemplate.getForObject(url,WeatherModel.class);

        return "" + weatherModel.getMain().getTemp();
    }




    @GetMapping("/weather/search")
    public String search(@RequestParam(required = false) String city, ModelMap modelMap) {

        if(city!=null) {
            String url = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=ef2028e98b54649bf1f4c4582631f350";
            RestTemplate restTemplate = new RestTemplate();
            WeatherModel weatherModel = restTemplate.getForObject(url,WeatherModel.class);
            modelMap.put("weather", weatherModel.getMain().getTemp());

        }

        return "index";
    }
}

package gwd.weatherforecast.model;

public class WeatherModel {


    private WeatherDetails main;


    public WeatherDetails getMain() {
        return main;
    }

    public void setMain(WeatherDetails main) {
        this.main = main;
    }

    public static class WeatherDetails {
        private double temp;

        public double getTemp() {
            return temp;
        }

        public double getTempinCelsium() {
            return (temp -273.15);
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }
    }
}

package Observer;

import Observer.Classes.CurrentConditionDisplay;
import Observer.Classes.WeatherData;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurements(80f, 65, 90.4f);
    }

}

package Observer.Classes;

import Observer.Interfaces.DisplayInterface;
import Observer.Interfaces.Observer;

public class CurrentConditionDisplay implements Observer, DisplayInterface {
    private float temperature;
    private float humidity;
    private float heatIndex;
    private WeatherData weatherData;

    public CurrentConditionDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current Conditions: " + temperature + "F degrees and " + humidity + "% humidity");
        System.out.println("Heat Index: " + heatIndex);
    }

    @Override
    public void update() {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        this.heatIndex = weatherData.getHeatIndex();
        display();
    }
}

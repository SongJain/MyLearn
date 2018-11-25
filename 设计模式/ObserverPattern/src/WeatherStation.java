
public class WeatherStation {
	//≤‚ ‘
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay currentConditionsDisplay = 
				new CurrentConditionsDisplay(weatherData);
		
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.0f);
		weatherData.setMeasurements(78, 75, 28.4f);
	}
}

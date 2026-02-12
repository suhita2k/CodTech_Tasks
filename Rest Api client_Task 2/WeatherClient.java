import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class WeatherClient {

    public static void main(String[] args) {
        try {
            String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=13.08&longitude=80.27&current_weather=true";

            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse JSON
            JSONObject json = new JSONObject(response.toString());
            JSONObject weather = json.getJSONObject("current_weather");

            double temperature = weather.getDouble("temperature");
            double windSpeed = weather.getDouble("windspeed");
            int weatherCode = weather.getInt("weathercode");

            // Display structured output
            System.out.println("===== Weather Report =====");
            System.out.println("Location       : Chennai");
            System.out.println("Temperature    : " + temperature + " °C");
            System.out.println("Wind Speed     : " + windSpeed + " km/h");
            System.out.println("Weather Code   : " + weatherCode);
            System.out.println("==========================");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

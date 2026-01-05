import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherClient {
    public static void main(String[] args) {
        try {
            // API URL
            String url = "https://api.open-meteo.com/v1/forecast?latitude=11.1&longitude=77.3&current_weather=true";

            // Create HTTP Client
            HttpClient client = HttpClient.newHttpClient();

            // Create Request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            // Send Request
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Display response
            System.out.println("Weather Data:");
            System.out.println(response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.example.tpd_server.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeolocationApi;
import com.google.maps.GeolocationApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.GeolocationResult;
import com.google.maps.model.LatLng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static com.example.tpd_server.util.IpUtils.getUserIpAddress;

public class ThirdPartyService {
    public LatLng getCoordinates() throws IOException {
        // Get the user's IP address
        String userIpAddress = getUserIpAddress(); // Implement your logic to get the user's IP address

        // Make an API request to retrieve the user's geolocation based on IP address
        String apiKey = "16087bdbc164f4c41e67764286ba31b0"; // Replace with your actual API key
        String apiUrl = "http://api.ipstack.com/" + userIpAddress + "?access_key=" + apiKey;
        LatLng coordinates = new LatLng();
        try {
            // Send HTTP GET request to the API
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the API response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse the JSON response
            JsonObject geolocationData = JsonParser.parseString(response.toString()).getAsJsonObject();

            // Extract the latitude and longitude from the geolocation data
            double latitude = geolocationData.get("latitude").getAsDouble();
            double longitude = geolocationData.get("longitude").getAsDouble();
            coordinates.lat = latitude;
            coordinates.lng = longitude;

            System.out.println("User's Location: " + latitude + ", " + longitude);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return coordinates;
    }
}

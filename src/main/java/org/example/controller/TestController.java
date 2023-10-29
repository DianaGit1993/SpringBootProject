package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/location")
public class TestController {

    @GetMapping("/current")
    public ResponseEntity<String> getCurrentLocation(HttpServletRequest request) {
        String userIpAddress = getUserIpAddress(request);

        // You can replace this logic with a more accurate geolocation service
        String userLocation = getLocationBasedOnIpAddress(userIpAddress);

        return ResponseEntity.ok(userLocation);
    }

    private String getUserIpAddress(HttpServletRequest request) {
        // Extract user's IP address from the request
        return request.getRemoteAddr();
    }

    private String getLocationBasedOnIpAddress(String ipAddress) {
        // Implement the logic to retrieve user location based on the IP address.
        // You can use a geolocation service or database for more accurate results.
        // For this example, we'll use ip-api.com.

        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://ip-api.com/json/" + ipAddress;
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return "Location not found";
        }
    }
}

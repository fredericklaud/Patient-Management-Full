package edu.secourse.patientportal.pmfrontend.config;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;

public class ApiClient {
    private static final String BASE_URL = "http://localhost:8080";

    private static final HttpClient client = HttpClient.newHttpClient();

    public static String post(String endpoint, String json, String token) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + endpoint))
                .header("Content-Type", "application/json")
                .header("Authorization", token != null ? "Bearer " + token : "")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }

    public static String get(String endpoint, String token) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + endpoint))
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }

    public static String put(String endpoint, String json, String token) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + endpoint))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }

    public static String delete(String endpoint, String token) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + endpoint))
                .header("Authorization", "Bearer " + token)
                .DELETE()
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }
}

package com.duannd.java11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Created By ngdduan@gmail.com at 12/1/18 1:10 PM
 */
public class ExHttpClient {

    public static void main(String args[]) throws Exception {
        get("https://www.google.com/");
        get("aaa");
    }

    private static void get(String url) throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();
        var client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

}

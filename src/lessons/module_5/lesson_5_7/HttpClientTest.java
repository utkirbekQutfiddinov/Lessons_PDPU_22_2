package lessons.module_5.lesson_5_7;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpClientTest {
    public static void main(String[] args) throws Exception {
        /**
         * HttpUrlConnection
         * HttpClient
         *
         * OkHttp
         * Apache http
         * web client
         * httpie
         */


        /** Request method types:
         * GET: read
         * POST: create
         * PUT: update
         * DELETE
         * PATCH
         *
         *
         */


        /**
         * Request tarkibi:
         * PathVariable: DELETE, GET
         * RequestParam: GET
         * RequestBody: POST, PUT
         * RequestHeader
         *
         */




    }

    private static void postWithAuth() throws URISyntaxException, IOException, InterruptedException {
        String usernamePassword="utkirbek9:EbzYlQYCRb";


        String auth="Basic "+ new String(Base64.getEncoder().encode(usernamePassword.getBytes()));

        String bodyStr="{\n" +
                "    \"firstName\":\"utkir\",\n" +
                "    \"lastName\":\"bek\"\n" +
                "}";


        String url="http://localhost:8082/trainees";

        HttpClient client= HttpClient.newBuilder().build();
        HttpRequest request= HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("Content-Type","application/json")
                .header("Authorization",auth)
                .POST(HttpRequest.BodyPublishers.ofString(bodyStr))
                .build();


        HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("send = " + send);
        System.out.println("send.body() = " + send.body());
    }

    private static void getWithAuth() throws URISyntaxException, IOException, InterruptedException {
        String usernamePassword="utkirbek9:EbzYlQYCRb";


        String url="http://localhost:8082/training-types";
        String auth="Basic "+ new String(Base64.getEncoder().encode(usernamePassword.getBytes()));


        HttpClient client= HttpClient.newBuilder().build();
        HttpRequest request= HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("Authorization",auth)
                .GET()
                .build();

        HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("send = " + send);
        System.out.println("send.body() = " + send.body());
    }

    private static void postWithBody() throws URISyntaxException, IOException, InterruptedException {
        String bodyStr="{\n" +
                "    \"firstName\":\"utkir\",\n" +
                "    \"lastName\":\"bek\"\n" +
                "}";


        String url="http://localhost:8082/trainees";

        HttpClient client= HttpClient.newBuilder().build();
        HttpRequest request= HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(bodyStr))
                .build();


        HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("send.body() = " + send.body());
    }

    private static void getWithParams() throws URISyntaxException, IOException, InterruptedException {
        String url="https://api.chucknorris.io/jokes/random";


        Map<String,String> paramsMap=Map.of(
                "username","admin",
                "password","124"
        );

        String params = paramsMap
                .entrySet()
                .stream()
                .map((e) -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining("&"));

        HttpClient client= HttpClient.newBuilder().build();
        HttpRequest request= HttpRequest
                .newBuilder()
                .uri(new URI(url+"?"+params))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());


        System.out.println(response);
    }

    private static void simpleGet() throws URISyntaxException, IOException, InterruptedException {
        String url="https://api.chucknorris.io/jokes/random";

        HttpClient client= HttpClient.newBuilder().build();
        HttpRequest request= HttpRequest
                .newBuilder()
                .uri(new URI(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());


        System.out.println(response);
    }
}

package br.com.infnet.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class HttpUtil {
    public int requisicaoParaParaleloSucesso(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/hello/paraleloSucesso"))
                    .GET()
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());
            return send.statusCode();

        } catch (URISyntaxException e) {
            System.out.println("URL INVALIDA");
        } catch (IOException e) {
            System.out.println("Algo Errado aconteceu");
        } catch (InterruptedException e) {
            System.out.println("Algo Errado aconteceu");
        }
        return 500;
    }
    public int getCodigoDaRequisicao(String url){
        int codigoResposta = 500;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());
            codigoResposta = send.statusCode();
        } catch (URISyntaxException e) {
            System.out.println("Algo de Errado aconteceu");

        } catch (IOException e) {
            System.out.println("Algo de Errado aconteceu");
        } catch (InterruptedException e) {
            System.out.println("Algo de Errado aconteceu");

        }
        return codigoResposta;
    }

    public List<String> getTopJogadores(int quantidadeDeJogadores) {
        try {
            String url = "http://localhost:8080/hello/lista?size=" + quantidadeDeJogadores;
            System.out.println(url);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            List<String> nomes = List.of(objectMapper.readValue(send.body(), String[].class));

            return nomes;
        } catch (URISyntaxException e) {


        } catch (IOException e) {

        } catch (InterruptedException e) {

        }
        return new ArrayList<String>();
    }
    public void surpresa(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/hello/lento"))
                    .GET()
                    .timeout(Duration.of(5, ChronoUnit.SECONDS))
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (HttpTimeoutException ex){
            System.out.println("ops aconteceu um timeout");
        } catch (URISyntaxException e) {
            System.out.println("Algo errado aconteceu");
        } catch (IOException e) {
            System.out.println("Algo errado aconteceu");
        } catch (InterruptedException e) {
            System.out.println("Algo errado aconteceu");
        }
    }
}

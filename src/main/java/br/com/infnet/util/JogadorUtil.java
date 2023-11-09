package br.com.infnet.util;

import br.com.infnet.model.Jogador;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JogadorUtil {
    public Jogador getJogador(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/jogador/umJogador"))
                    .GET()
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(send.body());
            ObjectMapper objectMapper = new ObjectMapper();
            Jogador jogador = objectMapper.readValue(send.body(), Jogador.class);
            return jogador;
        } catch (URISyntaxException e) {

        } catch (IOException e) {

        } catch (InterruptedException e) {

        }
        return null;
    }
    public void enviaJogador(Jogador jogador){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jogadorJson = objectMapper.writeValueAsString(jogador);
            System.out.println(jogadorJson);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/hello/recebendo"))
                    .POST(HttpRequest.BodyPublishers.ofString(jogadorJson))
                    .header("Content-Type", "application/json")
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> resposta = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(resposta.statusCode());

        } catch (JsonProcessingException e) {

        } catch (URISyntaxException e) {

        } catch (IOException e) {

        } catch (InterruptedException e) {

        }

    }
}

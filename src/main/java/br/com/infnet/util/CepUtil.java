package br.com.infnet.util;

import br.com.infnet.model.Endereco;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepUtil {
    public Endereco getEnderecoFromCep(String cep){
        String url = "https://viacep.com.br/ws/" +  cep + "/json/";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            Endereco endereco = mapper.readValue(send.body(), Endereco.class);
            return endereco;
        } catch (URISyntaxException e) {
                e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        } catch (InterruptedException e) {
            e.getMessage();
        }
        return null;

    }
}

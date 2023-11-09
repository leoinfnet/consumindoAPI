package br.com.infnet;

import br.com.infnet.util.HttpUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class HttpUtilsTest {
    @Test
    @DisplayName("Deve retornar o codigo 200")
    public void testaCodigo200(){
        //Fazer uma requisicao para http://localhost:8080/hello/paraleloSucesso
        HttpUtil httpUtil = new HttpUtil();
        int retorno = httpUtil.requisicaoParaParaleloSucesso();
        assertEquals(200,retorno);
        //Assert se o status code 200
    }
    @Test
    @DisplayName("Deve testar codigos de Erro")
    public void testaCodigosDeErro(){
        //Fazer uma requisicao para http://localhost:8080/hello/paraleloSucesso
        HttpUtil httpUtil = new HttpUtil();
        int retorno = httpUtil.getCodigoDaRequisicao("http://localhost:8080/hello/comErro");
        assertEquals(404,retorno);
        retorno = httpUtil.getCodigoDaRequisicao("http://localhost:8080/hello/paraleloErro");
        assertEquals(500,retorno);
        //Assert se o status code 200
    }
    @Test
    @DisplayName("Deve testar a lista retornada")
    public void testaRetornoComCorpo(){
        //Fazer uma requisicao para http://localhost:8080/hello/paraleloSucesso
        HttpUtil httpUtil = new HttpUtil();
        List<String> topJogadores = httpUtil.getTopJogadores(5);
        List<String> top1Jogador = httpUtil.getTopJogadores(1);
        assertEquals(5,topJogadores.size());
        assertEquals(1,top1Jogador.size());
        assertEquals("Leonardo",top1Jogador.get(0));
    }
    @Test
    public void testaSurpresa(){
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.surpresa();
        System.out.println("Finalizado");
    }
}

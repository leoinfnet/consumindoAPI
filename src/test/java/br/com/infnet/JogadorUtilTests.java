package br.com.infnet;

import br.com.infnet.model.Jogador;
import br.com.infnet.model.StatusPartida;
import br.com.infnet.util.JogadorUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class JogadorUtilTests {
    @Test
    public void retornaUmJogador(){
        JogadorUtil jogadorUtil = new JogadorUtil();
        Jogador jogador = jogadorUtil.getJogador();
        assertEquals(jogador.getNickname(), "LGloria");
    }
    @Test
    public void EnviaUmJogador(){
        JogadorUtil jogadorUtil = new JogadorUtil();
        Jogador jogador = new Jogador();
        jogador.setNickname("Teeste");
        jogador.setPontos(1400L);
        jogador.setUltimasPartidas(List.of(StatusPartida.VITORIA, StatusPartida.DERROTA, StatusPartida.HUMILHACAO));
        jogadorUtil.enviaJogador(jogador);
    }
}

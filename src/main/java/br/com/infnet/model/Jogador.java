package br.com.infnet.model;

import lombok.Data;

import java.util.List;

@Data
public class Jogador {
    private String nickname;
    private Long pontos;
    List<StatusPartida> ultimasPartidas;
}

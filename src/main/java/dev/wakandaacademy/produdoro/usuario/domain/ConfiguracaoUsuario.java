package dev.wakandaacademy.produdoro.usuario.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder(access = AccessLevel.PACKAGE)
@Getter
public class ConfiguracaoUsuario {
    private Integer tempoFoco;
    private Integer tempoPausaCurta;
    private Integer tempoPausaLonga;
    private Integer repeticoesParaPausaLonga;
}

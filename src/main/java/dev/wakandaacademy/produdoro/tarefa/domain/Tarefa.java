package dev.wakandaacademy.produdoro.tarefa.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Tarefa")
public class Tarefa {
    @Id
    private UUID id;
    private String nome;
    private String descricao;
    @Indexed
    private UUID idUsuario;
    @Indexed
    private UUID idArea;
    @Indexed
    private UUID idProjeto;
    @Builder.Default
    private StatusTarefa statusTarefa = StatusTarefa.A_FAZER;
}

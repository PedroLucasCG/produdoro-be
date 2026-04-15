package dev.wakandaacademy.produdoro.projeto.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Area")
public class Area {
    @Id
    private UUID id;
    private String nome;
    private String descricao;
    @Indexed
    private UUID idArea;
}

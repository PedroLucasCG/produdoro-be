package dev.wakandaacademy.produdoro.usuario.domain;

import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor (access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Usuario")
public class Usuario {
    @Id
    private UUID id;
    @Email
    @Indexed(unique = true)
    private String email;
    private ConfiguracaoUsuario configuracao;
    @Builder.Default
    private StatusUsuario status = StatusUsuario.FOCO;
    @Builder.Default
    private Integer qtdPomodorosPausaCurta = 0;
}

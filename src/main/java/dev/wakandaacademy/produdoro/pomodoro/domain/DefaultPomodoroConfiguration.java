package dev.wakandaacademy.produdoro.pomodoro.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "DefaultPomodoroConfiguration")
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class DefaultPomodoroConfiguration {
    @Builder.Default
    private static final String DEFAULT_CODE = "DEFAULT";
    @MongoId(targetType = FieldType.STRING)
    private String code;
    private Integer tempoFoco;
    private Integer tempoPausaCurta;
    private Integer tempoPausaLonga;
    private Integer repeticoesParaPausaLonga;
}

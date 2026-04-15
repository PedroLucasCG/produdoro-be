package dev.wakandaacademy.produdoro.credential.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Document(collection = "Credential")
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Credential {
    @MongoId(targetType = FieldType.STRING)
    private String usurname;
    private String password;

    public Credential(String usurname, String password) {
        this.usurname = usurname;
        this.password = new BCryptPasswordEncoder().encode(password);
    }

}

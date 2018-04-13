package io.github.ganchix.arangodb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterActorRequest {
    private String name;
    private String surname;
    private boolean alive;
    private Integer age;
}

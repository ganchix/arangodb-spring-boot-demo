package io.github.ganchix.arangodb.service;

import io.github.ganchix.arangodb.domain.CharacterActor;
import io.github.ganchix.arangodb.dto.CharacterActorRequest;

import java.util.List;
import java.util.Optional;

public interface CharacterService {
    List<CharacterActor> getAll();

    void insertAll();

    void deleteAll();

    CharacterActor addCharacter(CharacterActorRequest characterActorRequest);

    Optional<CharacterActor> get(String id);
}

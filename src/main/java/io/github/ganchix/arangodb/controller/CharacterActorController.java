package io.github.ganchix.arangodb.controller;

import io.github.ganchix.arangodb.domain.CharacterActor;
import io.github.ganchix.arangodb.dto.CharacterActorRequest;
import io.github.ganchix.arangodb.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterActorController {

    @Autowired
    CharacterService characterService;

    @GetMapping("/all")
    public List<CharacterActor> getAll() {
        return characterService.getAll();
    }

    @PostMapping("/all")
    public List<CharacterActor> addAll() {
        characterService.insertAll();
        return characterService.getAll();
    }


    @DeleteMapping("/all")
    public List<CharacterActor> delete() {
        characterService.deleteAll();
        return characterService.getAll();
    }


    @GetMapping("/{id}")
    public CharacterActor get(@PathVariable String id) {
        return characterService.get(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/")
    public CharacterActor add(@RequestBody CharacterActorRequest characterActorRequest) {
        return characterService.addCharacter(characterActorRequest);
    }

}

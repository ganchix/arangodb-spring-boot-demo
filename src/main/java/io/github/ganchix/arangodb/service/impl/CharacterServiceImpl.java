package io.github.ganchix.arangodb.service.impl;


import com.google.common.collect.Lists;
import io.github.ganchix.arangodb.domain.CharacterActor;
import io.github.ganchix.arangodb.dto.CharacterActorRequest;
import io.github.ganchix.arangodb.repository.CharacterRepository;
import io.github.ganchix.arangodb.service.CharacterService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    Mapper mapper;

    @Override
    public List<CharacterActor> getAll() {
        return Lists.newArrayList(characterRepository.findAll());
    }

    @Override
    public void insertAll() {
        List<CharacterActor> characterActors = Arrays.asList(new CharacterActor("Ned", "Stark", false, 41), new CharacterActor("Robert", "Baratheon", false),
                new CharacterActor("Jaime", "Lannister", true, 36), new CharacterActor("Catelyn", "Stark", false, 40),
                new CharacterActor("Cersei", "Lannister", true, 36), new CharacterActor("Daenerys", "Targaryen", true, 16),
                new CharacterActor("Jorah", "Mormont", false), new CharacterActor("Petyr", "Baelish", false),
                new CharacterActor("Viserys", "Targaryen", false), new CharacterActor("Jon", "Snow", true, 16),
                new CharacterActor("Sansa", "Stark", true, 13), new CharacterActor("Arya", "Stark", true, 11),
                new CharacterActor("Robb", "Stark", false), new CharacterActor("Theon", "Greyjoy", true, 16),
                new CharacterActor("Bran", "Stark", true, 10), new CharacterActor("Joffrey", "Baratheon", false, 19),
                new CharacterActor("Sandor", "Clegane", true), new CharacterActor("Tyrion", "Lannister", true, 32),
                new CharacterActor("Khal", "Drogo", false), new CharacterActor("Tywin", "Lannister", false),
                new CharacterActor("Davos", "Seaworth", true, 49), new CharacterActor("Samwell", "Tarly", true, 17),
                new CharacterActor("Stannis", "Baratheon", false), new CharacterActor("Melisandre", null, true),
                new CharacterActor("Margaery", "Tyrell", false), new CharacterActor("Jeor", "Mormont", false),
                new CharacterActor("Bronn", null, true), new CharacterActor("Varys", null, true), new CharacterActor("Shae", null, false),
                new CharacterActor("Talisa", "Maegyr", false), new CharacterActor("Gendry", null, false),
                new CharacterActor("Ygritte", null, false), new CharacterActor("Tormund", "Giantsbane", true),
                new CharacterActor("Gilly", null, true), new CharacterActor("Brienne", "Tarth", true, 32),
                new CharacterActor("Ramsay", "Bolton", true), new CharacterActor("Ellaria", "Sand", true),
                new CharacterActor("Daario", "Naharis", true), new CharacterActor("Missandei", null, true),
                new CharacterActor("Tommen", "Baratheon", true), new CharacterActor("Jaqen", "H'ghar", true),
                new CharacterActor("Roose", "Bolton", true), new CharacterActor("The High Sparrow", null, true));
        characterRepository.saveAll(characterActors);
    }

    @Override
    public void deleteAll() {
        characterRepository.deleteAll();
    }

    @Override
    public CharacterActor addCharacter(CharacterActorRequest characterActorRequest) {
        CharacterActor characterActor = mapper.map(characterActorRequest, CharacterActor.class);
        return characterRepository.save(characterActor);
    }

    @Override
    public Optional<CharacterActor> get(String id){
        return characterRepository.findById(id);
    }
}

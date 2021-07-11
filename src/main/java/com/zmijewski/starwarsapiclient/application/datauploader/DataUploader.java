package com.zmijewski.starwarsapiclient.application.datauploader;

import com.zmijewski.starwarsapiclient.domain.entity.PlanetEntity;
import com.zmijewski.starwarsapiclient.domain.entity.StarshipEntity;
import com.zmijewski.starwarsapiclient.domain.repository.CharacterRepository;
import com.zmijewski.starwarsapiclient.domain.repository.PlanetRepository;
import com.zmijewski.starwarsapiclient.domain.repository.StarshipRepository;
import com.zmijewski.starwarsapiclient.application.mapper.CharacterMapper;
import com.zmijewski.starwarsapiclient.application.mapper.PlanetMapper;
import com.zmijewski.starwarsapiclient.application.mapper.StarshipMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class DataUploader {
    private final DataFetcher dataFetcher;
    private final StarshipMapper starshipMapper;
    private final PlanetMapper planetMapper;
    private final CharacterMapper characterMapper;
    private final StarshipRepository starshipRepository;
    private final PlanetRepository planetRepository;
    private final CharacterRepository characterRepository;

    @Transactional
    public void uploadDataFromApi() {
        var starships = getStarships();
        var planets = getPlanets();
        var characters = dataFetcher.getCharacters()
                .stream()
                .map(characterDTO -> characterMapper.map(characterDTO, planets, starships))
                .collect(Collectors.toList());
        planetRepository.saveAll(planets.values());
        starshipRepository.saveAll(starships.values());
        characterRepository.saveAll(characters);
    }

    public Map<Long, StarshipEntity> getStarships() {
        return dataFetcher.getStarships()
                .stream()
                .map(starshipMapper::map)
                .collect(Collectors.toMap(StarshipEntity::getId, starshipEntity -> starshipEntity));
    }

    public Map<Long, PlanetEntity> getPlanets() {
        return dataFetcher.getPlanets()
                .stream()
                .map(planetMapper::map)
                .collect(Collectors.toMap(PlanetEntity::getId, planetEntity -> planetEntity));
    }
}

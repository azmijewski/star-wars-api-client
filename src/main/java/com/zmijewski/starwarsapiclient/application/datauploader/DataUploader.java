package com.zmijewski.starwarsapiclient.application.datauploader;

import com.zmijewski.starwarsapiclient.domain.entity.HomeWorldEntity;
import com.zmijewski.starwarsapiclient.domain.entity.StarshipEntity;
import com.zmijewski.starwarsapiclient.domain.repository.CharacterRepository;
import com.zmijewski.starwarsapiclient.domain.repository.HomeWorldRepository;
import com.zmijewski.starwarsapiclient.domain.repository.StarshipRepository;
import com.zmijewski.starwarsapiclient.application.mapper.CharacterMapper;
import com.zmijewski.starwarsapiclient.application.mapper.HomeworldMapper;
import com.zmijewski.starwarsapiclient.application.mapper.StarshipMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DataUploader {
    private final DataFetcher dataFetcher;
    private final CharacterRepository characterRepository;
    private final StarshipMapper starshipMapper;
    private final HomeworldMapper homeworldMapper;
    private final CharacterMapper characterMapper;
    private final StarshipRepository starshipRepository;
    private final HomeWorldRepository homeWorldRepository;

    @Transactional
    public void uploadDataFromApi() {
        var starships = getStarships();
        var homeWorlds = getHomeWorlds();
        var characters = dataFetcher.getCharacters()
                .stream()
                .map(characterDTO -> characterMapper.map(characterDTO, homeWorlds, starships))
                .collect(Collectors.toList());
        homeWorldRepository.saveAll(homeWorlds.values());
        starshipRepository.saveAll(starships.values());
        characterRepository.saveAll(characters);
    }

    public Map<Long, StarshipEntity> getStarships() {
        return dataFetcher.getStarships()
                .stream()
                .map(starshipMapper::map)
                .collect(Collectors.toMap(StarshipEntity::getId, starshipEntity -> starshipEntity));
    }

    public Map<Long, HomeWorldEntity> getHomeWorlds() {
        return dataFetcher.getHomeWorlds()
                .stream()
                .map(homeworldMapper::map)
                .collect(Collectors.toMap(HomeWorldEntity::getId, homeWorldEntity -> homeWorldEntity));
    }
}

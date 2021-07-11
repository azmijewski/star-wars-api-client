package com.zmijewski.starwarsapiclient.application.mapper;

import com.zmijewski.starwarsapiclient.api.model.CharacterModel;
import com.zmijewski.starwarsapiclient.client.dto.CharacterDTO;
import com.zmijewski.starwarsapiclient.domain.entity.CharacterEntity;
import com.zmijewski.starwarsapiclient.domain.entity.PlanetEntity;
import com.zmijewski.starwarsapiclient.domain.entity.StarshipEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CharacterMapper {
    private final IdExtractor idExtractor;
    private final StarshipMapper starshipMapper;
    private final PlanetMapper planetMapper;

    public CharacterEntity map(CharacterDTO characterDTO, Map<Long, PlanetEntity> planetMap, Map<Long, StarshipEntity> starshipMap) {
        var starships = characterDTO.getStarships()
                .stream()
                .map(starshipUrl -> this.getStarship(starshipMap, starshipUrl))
                .collect(Collectors.toSet());

        return new CharacterEntity(idExtractor.extractCharacterId(characterDTO.getUrl()), characterDTO.getName(),
                characterDTO.getHeight(), characterDTO.getMass(), characterDTO.getHairColor(),
                characterDTO.getSkinColor(), characterDTO.getEyeColor(), characterDTO.getBirthYear(),
                characterDTO.getGender(), getHomeworld(planetMap, characterDTO.getHomeworld()), starships);
    }

    public CharacterModel map(CharacterEntity characterEntity) {
        var starships = characterEntity.getStarships()
                .stream()
                .map(starshipMapper::map)
                .collect(Collectors.toList());

        return new CharacterModel(characterEntity.getId(), characterEntity.getName(), characterEntity.getHeight(),
                characterEntity.getMass(), characterEntity.getHairColor(), characterEntity.getSkinColor(),
                characterEntity.getEyeColor(), characterEntity.getBirthYear(), characterEntity.getGender(), starships,
                planetMapper.map(characterEntity.getHomeworld()));
    }

    private PlanetEntity getHomeworld(Map<Long, PlanetEntity> planetMap, String url) {
        return planetMap.get(idExtractor.extractPlanetId(url));
    }

    private StarshipEntity getStarship(Map<Long, StarshipEntity> starshipMap, String url) {
        return starshipMap.get(idExtractor.extractStarshipId(url));
    }
}

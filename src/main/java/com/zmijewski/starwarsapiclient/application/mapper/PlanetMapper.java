package com.zmijewski.starwarsapiclient.application.mapper;

import com.zmijewski.starwarsapiclient.api.model.PlanetModel;
import com.zmijewski.starwarsapiclient.client.dto.PlanetDTO;
import com.zmijewski.starwarsapiclient.domain.entity.PlanetEntity;
import com.zmijewski.starwarsapiclient.application.datauploader.IdExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlanetMapper {
    private final IdExtractor idExtractor;

    public PlanetEntity map(PlanetDTO planetDTO) {
        return new PlanetEntity(idExtractor.extractPlanetId(planetDTO.getUrl()), planetDTO.getName(),
                planetDTO.getRotationPeriod(), planetDTO.getOrbitalPeriod(), planetDTO.getDiameter(),
                planetDTO.getClimate(), planetDTO.getGravity(), planetDTO.getTerrain(),
                planetDTO.getSurfaceWater(), planetDTO.getPopulation());
    }

    public PlanetModel map(PlanetEntity planetEntity) {
        return new PlanetModel(planetEntity.getName(), planetEntity.getRotationPeriod(),
                planetEntity.getOrbitalPeriod(), planetEntity.getDiameter(), planetEntity.getClimate(),
                planetEntity.getGravity(), planetEntity.getTerrain(), planetEntity.getSurfaceWater(),
                planetEntity.getPopulation());
    }
}

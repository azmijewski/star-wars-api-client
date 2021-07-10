package com.zmijewski.starwarsapiclient.application.mapper;

import com.zmijewski.starwarsapiclient.api.model.HomeWorldModel;
import com.zmijewski.starwarsapiclient.client.dto.HomeWorldDTO;
import com.zmijewski.starwarsapiclient.domain.entity.HomeWorldEntity;
import com.zmijewski.starwarsapiclient.application.datauploader.IdExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HomeworldMapper {
    private final IdExtractor idExtractor;

    public HomeWorldEntity map(HomeWorldDTO homeWorldDTO) {
        return new HomeWorldEntity(idExtractor.extractHomeworldId(homeWorldDTO.getUrl()), homeWorldDTO.getName(),
                homeWorldDTO.getRotationPeriod(), homeWorldDTO.getOrbitalPeriod(), homeWorldDTO.getDiameter(),
                homeWorldDTO.getClimate(), homeWorldDTO.getGravity(), homeWorldDTO.getTerrain(),
                homeWorldDTO.getSurfaceWater(), homeWorldDTO.getPopulation());
    }

    public HomeWorldModel map(HomeWorldEntity homeWorldEntity) {
        return new HomeWorldModel(homeWorldEntity.getName(), homeWorldEntity.getRotationPeriod(),
                homeWorldEntity.getOrbitalPeriod(), homeWorldEntity.getDiameter(), homeWorldEntity.getClimate(),
                homeWorldEntity.getGravity(), homeWorldEntity.getTerrain(), homeWorldEntity.getSurfaceWater(),
                homeWorldEntity.getPopulation());
    }
}

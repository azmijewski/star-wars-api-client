package com.zmijewski.starwarsapiclient.application.mapper;

import com.zmijewski.starwarsapiclient.api.model.StarshipModel;
import com.zmijewski.starwarsapiclient.client.dto.StarshipDTO;
import com.zmijewski.starwarsapiclient.domain.entity.StarshipEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StarshipMapper {
    private final IdExtractor idExtractor;

    public StarshipEntity map(StarshipDTO starshipDTO) {
        return new StarshipEntity(idExtractor.extractStarshipId(starshipDTO.getUrl()), starshipDTO.getName(),
                starshipDTO.getModel(), starshipDTO.getManufacturer(), starshipDTO.getCostInCredits(),
                starshipDTO.getLength(), starshipDTO.getMaxAtmospheringSpeed(), starshipDTO.getCrew(),
                starshipDTO.getPassengers(), starshipDTO.getCargoCapacity(), starshipDTO.getConsumables(),
                starshipDTO.getHyperdriveRating(), starshipDTO.getMglt(), starshipDTO.getStarshipClass());
    }

    public StarshipModel map(StarshipEntity starshipEntity) {
        return new StarshipModel(starshipEntity.getName(), starshipEntity.getModel(), starshipEntity.getManufacturer(),
                starshipEntity.getCostInCredits(), starshipEntity.getLength(), starshipEntity.getMaxAtmospheringSpeed(),
                starshipEntity.getCrew(), starshipEntity.getPassengers(), starshipEntity.getCargoCapacity(),
                starshipEntity.getConsumables(), starshipEntity.getHyperdriveRating(), starshipEntity.getMglt(),
                starshipEntity.getStarshipClass());
    }
}

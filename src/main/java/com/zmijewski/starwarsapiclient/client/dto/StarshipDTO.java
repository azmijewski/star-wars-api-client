package com.zmijewski.starwarsapiclient.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Value;

@Value
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class StarshipDTO {
    String name;
    String model;
    String starshipClass;
    String manufacturer;
    String costInCredits;
    String length;
    String crew;
    String passengers;
    String maxAtmospheringSpeed;
    String hyperdriveRating;
    String cargoCapacity;
    String consumables;
    @JsonProperty("MGLT")
    String mglt;
    String url;
}

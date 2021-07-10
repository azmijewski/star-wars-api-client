package com.zmijewski.starwarsapiclient.api.model;

import lombok.Value;

@Value
public class StarshipModel {
    String name;
    String model;
    String manufacturer;
    String costInCredits;
    String length;
    String maxAtmospheringSpeed;
    String crew;
    String passengers;
    String cargoCapacity;
    String consumables;
    String hyperdriveRating;
    String mglt;
    String starshipClass;
}

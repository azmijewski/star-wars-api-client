package com.zmijewski.starwarsapiclient.api.model;

import lombok.Value;

import java.util.List;

@Value
public class CharacterModel {
    Long id;
    String name;
    String height;
    String mass;
    String hairColor;
    String skinColor;
    String eyeColor;
    String birthYear;
    String gender;
    List<StarshipModel> starships;
    PlanetModel homeworld;
}

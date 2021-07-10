package com.zmijewski.starwarsapiclient.domain.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Table(name = "starship")
public class StarshipEntity {
    @Id
    private Long id;

    private String name;

    private String model;

    private String manufacturer;

    private String costInCredits;

    private String length;

    private String maxAtmospheringSpeed;

    private String crew;

    private String passengers;

    private String cargoCapacity;

    private String consumables;

    private String hyperdriveRating;

    private String mglt;

    private String starshipClass;
}

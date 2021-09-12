package com.zmijewski.starwarsapiclient.domain.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Set;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Table(name = "character")
public class CharacterEntity {
    @Id
    private Long id;

    private String name;

    private String height;

    private String mass;

    private String hairColor;

    private String skinColor;

    private String eyeColor;

    private String birthYear;


    private String gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "homeworld")
    private PlanetEntity homeworld;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "character_starship",
        joinColumns = @JoinColumn(name = "character_id"),
        inverseJoinColumns = @JoinColumn(name = "starship_id"))
    Set<StarshipEntity> starships;
}

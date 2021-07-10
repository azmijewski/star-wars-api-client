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
@Table(name = "homeworld")
public class HomeWorldEntity {
    @Id
    private Long id;

    private String name;

    private String rotationPeriod;

    private String orbitalPeriod;

    private String diameter;

    private String climate;

    private String gravity;

    private String terrain;

    private String surfaceWater;

    private String population;
}

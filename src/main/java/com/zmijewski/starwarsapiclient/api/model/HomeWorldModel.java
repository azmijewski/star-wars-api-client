package com.zmijewski.starwarsapiclient.api.model;

import lombok.Value;

@Value
public class HomeWorldModel {
    String name;
    String rotationPeriod;
    String orbitalPeriod;
    String diameter;
    String climate;
    String gravity;
    String terrain;
    String surfaceWater;
    String population;
}

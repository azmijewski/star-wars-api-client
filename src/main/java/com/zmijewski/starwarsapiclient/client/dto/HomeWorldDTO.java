package com.zmijewski.starwarsapiclient.client.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Value;

@Value
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class HomeWorldDTO {
    String name;
    String climate;
    String diameter;
    String gravity;
    String orbitalPeriod;
    String population;
    String rotationPeriod;
    String surfaceWater;
    String terrain;
    String url;
}

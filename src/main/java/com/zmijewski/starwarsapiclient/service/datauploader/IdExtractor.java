package com.zmijewski.starwarsapiclient.service.datauploader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IdExtractor {
    @Value("${starwarsapi.resources.characters}")
    private String characterUrl;

    @Value("${starwarsapi.resources.homeworlds}")
    private String homeworldUrl;

    @Value("${starwarsapi.resources.starships}")
    private String starshipUrl;

    public Long extractCharacterId(String url) {
        return extractId(url, characterUrl);
    }

    public Long extractHomeworldId(String url) {
        return extractId(url, homeworldUrl);
    }

    public Long extractStarshipId(String url) {
        return extractId(url, starshipUrl);
    }

    private Long extractId(String url, String prefix) {
        return Long.valueOf(url.replace(prefix, ""));
    }
}

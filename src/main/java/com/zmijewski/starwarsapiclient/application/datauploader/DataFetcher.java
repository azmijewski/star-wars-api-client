package com.zmijewski.starwarsapiclient.application.datauploader;

import com.zmijewski.starwarsapiclient.client.StarWarsClient;
import com.zmijewski.starwarsapiclient.client.dto.CharacterDTO;
import com.zmijewski.starwarsapiclient.client.dto.HomeWorldDTO;
import com.zmijewski.starwarsapiclient.client.dto.PageDTO;
import com.zmijewski.starwarsapiclient.client.dto.StarshipDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


@Component
@RequiredArgsConstructor
public class DataFetcher {
    private final StarWarsClient starWarsClient;

    public List<CharacterDTO> getCharacters() {
        return fetchData(starWarsClient::getCharacters);
    }

    public List<StarshipDTO> getStarships() {
        return fetchData(starWarsClient::getStarships);
    }

    public List<HomeWorldDTO> getHomeWorlds() {
        return fetchData(starWarsClient::getHomeWorlds);
    }

    private <T> List<T> fetchData(Function<Integer, PageDTO<T>> function) {
        var counter = 1;
        var data = new ArrayList<T>();
        PageDTO<T> page;

        do {
            page = function.apply(counter);
            data.addAll(page.getResults());
            counter++;
        } while (page.getNext() != null);

        return data;
    }
}

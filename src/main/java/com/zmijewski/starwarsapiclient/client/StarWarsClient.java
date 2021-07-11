package com.zmijewski.starwarsapiclient.client;

import com.zmijewski.starwarsapiclient.client.dto.CharacterDTO;
import com.zmijewski.starwarsapiclient.client.dto.PlanetDTO;
import com.zmijewski.starwarsapiclient.client.dto.PageDTO;
import com.zmijewski.starwarsapiclient.client.dto.StarshipDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "starwars",
        url = "${starwarsapi.url}",
        configuration = StarWarsClientConfig.class,
        decode404 = true
)
public interface StarWarsClient {
    @GetMapping("people/")
    PageDTO<CharacterDTO> getCharacters(@RequestParam("page") Integer page);

    @GetMapping("planets/")
    PageDTO<PlanetDTO> getPlanets(@RequestParam("page") Integer page);

    @GetMapping("starships/")
    PageDTO<StarshipDTO> getStarships(@RequestParam("page") Integer page);
}

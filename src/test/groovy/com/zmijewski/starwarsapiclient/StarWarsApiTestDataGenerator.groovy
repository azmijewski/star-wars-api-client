package com.zmijewski.starwarsapiclient

import com.zmijewski.starwarsapiclient.client.dto.CharacterDTO
import com.zmijewski.starwarsapiclient.client.dto.PlanetDTO
import com.zmijewski.starwarsapiclient.client.dto.PageDTO
import com.zmijewski.starwarsapiclient.client.dto.StarshipDTO

import static com.zmijewski.starwarsapiclient.StarWarsApiTestConstants.CHARACTER_URL
import static com.zmijewski.starwarsapiclient.StarWarsApiTestConstants.PLANET_URL
import static com.zmijewski.starwarsapiclient.StarWarsApiTestConstants.STARSHIP_URL

class StarWarsApiTestDataGenerator {
    static PageDTO<CharacterDTO> generateCharacters() {
        def character1 = new CharacterDTO("TestName1", "172", "77", "blond", "fair", "blue",
                "19BBY", "male", "${CHARACTER_URL}1".toString(),
                "${PLANET_URL}1".toString(),  ["${STARSHIP_URL}1".toString(), "${STARSHIP_URL}2".toString()])
        def character2 = new CharacterDTO("TestName2", "167", "75", "n/a", "gold", "yellow",
                "112BBY", "n/a", "${CHARACTER_URL}2".toString(),
                "${PLANET_URL}1".toString(),  [])
        def character3 = new CharacterDTO("TestName3", "96", "32", "n/a", "white, blue", "red",
                "33BBY", "n/a", "${CHARACTER_URL}3".toString(),
                "${PLANET_URL}3".toString(),  [])
        def character4 = new CharacterDTO("TestName4", "202", "136", "none", "white", "yellow",
                "41.9BBY", "male", "${CHARACTER_URL}4".toString(),
                "${PLANET_URL}1".toString(),  ["${STARSHIP_URL}3".toString()])
        def character5 = new CharacterDTO("TestName5", "150", "49", "brown", "light", "brown",
                "19BBY", "female", "${CHARACTER_URL}5".toString(),
                "${PLANET_URL}2".toString(),  [])
        def character6 = new CharacterDTO("TestName6", "178", "120", "brown, grey", "light", "blue",
                "52BBY", "male", "${CHARACTER_URL}6".toString(),
                "${PLANET_URL}1".toString(),  [])
        def character7 = new CharacterDTO("TestName7", "165", "75", "brown", "light", "blue",
                "47BBY", "female", "${CHARACTER_URL}7".toString(),
                "${PLANET_URL}1",  [])
        def character8 = new CharacterDTO("TestName8", "97", "32", "blond", "fair", "blue",
                "19BBY", "male", "${CHARACTER_URL}8".toString(),
                "${PLANET_URL}1".toString(),  [])
        def character9 = new CharacterDTO("TestName9", "175", "67", "blond", "fair", "blue",
                "195BBY", "male", "${CHARACTER_URL}9".toString(),
                "${PLANET_URL}1",  [])
        def character10 = new CharacterDTO("TestName10", "180", "90", "blond", "dark", "green",
                "21BBY", "male", "${CHARACTER_URL}10".toString(),
                "${PLANET_URL}1".toString(),  ["${STARSHIP_URL}4".toString(), "${STARSHIP_URL}5".toString()])
        return new PageDTO<CharacterDTO>(10, null, [character1, character2, character3, character4, character5, character6, character7, character8, character9, character10])
    }

    static PageDTO<StarshipDTO> generateStarships() {
        def starship1 = new StarshipDTO("Starship1", "Model1", "yacht", "manufacturer1",
                "1200", "65", "5", "12", "1.50", "1.5",
                "21000", "4 years", "unknown", "${STARSHIP_URL}1".toString())
        def starship2 = new StarshipDTO("Starship2", "Model2", "starfighter", "manufacturer2",
                "8000", "12", "1", "0", "6", "2",
                "300", "5 years", "unknown", "${STARSHIP_URL}2".toString())
        def starship3 = new StarshipDTO("Starship3", "Model3", "yacht", "manufacturer3",
                "4500", "14", "5", "20", "0.75", "0.5",
                "2000", "3 years", "unknown", "${STARSHIP_URL}3".toString())
        def starship4 = new StarshipDTO("Starship4", "Model4", "starfighter", "manufacturer4",
                "2300", "78", "7", "0", "8", "2.5",
                "532", "5 years", "unknown", "${STARSHIP_URL}4".toString())
        def starship5 = new StarshipDTO("Starship5", "Model5", "yacht", "manufacturer5",
                "850", "21", "3", "20", "1.50", "0.75",
                "25000", "4 years", "unknown", "${STARSHIP_URL}5".toString())
        def starship6 = new StarshipDTO("Starship6", "Model6", "starfighter", "manufacturer6",
                "1200", "unknown", "3", "o", "5.5", "1.5",
                "200", "3 years", "unknown", "${STARSHIP_URL}6".toString())
        return new PageDTO<StarshipDTO>(6, null, [starship1, starship2, starship3, starship4, starship5, starship6])
    }

    static PageDTO<PlanetDTO> generatePlanets() {
        def planet1 = new PlanetDTO("Planet1", "temperate", "0", "1", "360",
                "4000000", "24", "12", "dessert",
                "${PLANET_URL}1".toString())
        def planet2 = new PlanetDTO("Planet2", "strict", "unknown", "2", "100",
                "200000", "46", "0", "dessert",
                "${PLANET_URL}2".toString())
        def planet3 = new PlanetDTO("Planet3", "temperate", "unknown", "5", "5000",
                "unknown", "22", "200", "ice",
                "${PLANET_URL}3".toString())
        def planet4 = new PlanetDTO("Planet4", "strict", "0", "1", "3600",
                "4800000", "24", "5", "dessert",
                "${PLANET_URL}4".toString())
        return new PageDTO<PlanetDTO>(4, null, [planet1, planet2, planet3, planet4])
    }
}

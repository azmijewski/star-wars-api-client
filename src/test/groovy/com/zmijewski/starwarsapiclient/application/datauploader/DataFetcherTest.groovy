package com.zmijewski.starwarsapiclient.application.datauploader

import com.zmijewski.starwarsapiclient.StarWarsApiTestDataGenerator
import com.zmijewski.starwarsapiclient.client.StarWarsClient
import spock.lang.Specification
import spock.lang.Subject

class DataFetcherTest extends Specification {
    @Subject
    def dataFetcher
    def starWarsClient

    def setup() {
        starWarsClient = Mock(StarWarsClient) {
            it.getCharacters(_ as Integer) >> StarWarsApiTestDataGenerator.generateCharacters()
            it.getPlanets(_ as Integer) >> StarWarsApiTestDataGenerator.generatePlanets()
            it.getStarships(_ as Integer) >> StarWarsApiTestDataGenerator.generateStarships()
        }
        dataFetcher = new DataFetcher(starWarsClient)
    }

    def "should fetch characters"() {
        when:
        def characters = dataFetcher.getCharacters()

        then:
        characters.size == 10
    }

    def "should fetch planets"() {
        when:
        def planets = dataFetcher.getPlanets()

        then:
        planets.size == 4
    }

    def "should fetch starships"() {
        when:
        def starships = dataFetcher.getStarships()

        then:
        starships.size == 6
    }
}

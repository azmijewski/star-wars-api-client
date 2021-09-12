package com.zmijewski.starwarsapiclient.application.mapper

import spock.lang.Specification
import spock.lang.Subject

import static com.zmijewski.starwarsapiclient.StarWarsApiTestConstants.CHARACTER_URL
import static com.zmijewski.starwarsapiclient.StarWarsApiTestConstants.PLANET_URL
import static com.zmijewski.starwarsapiclient.StarWarsApiTestConstants.STARSHIP_URL

class IdExtractorTest extends Specification {
    @Subject
    def idExtractor

    def setup() {
        idExtractor = new IdExtractor()
        idExtractor.characterUrl = CHARACTER_URL
        idExtractor.planetUrl = PLANET_URL
        idExtractor.starshipUrl= STARSHIP_URL
    }

    def "should extract character id"() {
        when:
        def id = idExtractor.extractCharacterId("${CHARACTER_URL}1")

        then:
        id == 1
    }

    def "should extract planet id"() {
        when:
        def id = idExtractor.extractPlanetId("${PLANET_URL}2")

        then:
        id == 2
    }

    def "should extract starship id"() {
        when:
        def id = idExtractor.extractStarshipId("${STARSHIP_URL}3")

        then:
        id == 3
    }
}

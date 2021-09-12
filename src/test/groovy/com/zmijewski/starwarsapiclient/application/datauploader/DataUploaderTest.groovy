package com.zmijewski.starwarsapiclient.application.datauploader

import com.zmijewski.starwarsapiclient.IntegrationSpecification
import com.zmijewski.starwarsapiclient.StarWarsApiTestDataGenerator
import com.zmijewski.starwarsapiclient.domain.entity.CharacterEntity
import com.zmijewski.starwarsapiclient.domain.entity.PlanetEntity
import com.zmijewski.starwarsapiclient.domain.entity.StarshipEntity
import com.zmijewski.starwarsapiclient.domain.repository.CharacterRepository
import com.zmijewski.starwarsapiclient.domain.repository.PlanetRepository
import com.zmijewski.starwarsapiclient.domain.repository.StarshipRepository
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.jdbc.Sql
import org.springframework.transaction.annotation.Transactional
import spock.lang.Subject

@Transactional
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/sql/delete.sql")
class DataUploaderTest extends IntegrationSpecification {
    @Subject
    @Autowired
    private DataUploader dataUploader

    @Autowired
    private CharacterRepository characterRepository

    @Autowired
    private PlanetRepository planetRepository

    @Autowired
    private StarshipRepository starshipRepository

    @SpringBean
    private DataFetcher dataFetcher = Mock(DataFetcher) {
        it.getStarships() >> StarWarsApiTestDataGenerator.generateStarships().results
        it.getPlanets() >> StarWarsApiTestDataGenerator.generatePlanets().results
        it.getCharacters() >> StarWarsApiTestDataGenerator.generateCharacters().results
    }

    def "should upload data"() {
        when:
        dataUploader.uploadDataFromApi()

        then: "planets are uploaded"
        def planets = planetRepository.findAll()
        planets.size() == 4
        def planetToCheck = planets.find {it.id == 1} as PlanetEntity
        planetToCheck.name == "Planet1"

        and: "starships are uploaded"
        def starships = starshipRepository.findAll()
        starships.size() == 6
        def starshipToCheck = starships.find {it.id == 1} as StarshipEntity
        starshipToCheck.name == "Starship1"

        and: "characters are uploaded"
        def characters = characterRepository.findAll()
        characters.size() == 10
        def characterToCheck = characters.find {it.id == 1} as CharacterEntity
        characterToCheck.name == "TestName1"
        characterToCheck.homeworld.id == 1
        characterToCheck.starships.size() == 2
        characterToCheck.starships.find {it.id == 1}
        characterToCheck.starships.find {it.id == 2}
    }
}

package com.zmijewski.starwarsapiclient.api

import com.zmijewski.starwarsapiclient.IntegrationSpecification
import com.zmijewski.starwarsapiclient.api.model.CharacterModel
import org.springframework.http.HttpStatus
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/sql/delete.sql")
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/sql/insert-character-api.sql")
class CharacterApiTest extends IntegrationSpecification {
    private static final String BASE_URL = "/characters"

    def "should get character by id"() {
        when:
        def response = mockMvc.perform(getCharacterById(1L)).andReturn().response

        then: "status is ok"
        response.status == HttpStatus.OK.value()

        and: "response body is ok"
        def character = objectMapper.readValue(response.getContentAsString(), CharacterModel.class)
        character.id == 1
        character.name == "Luke Skywalker"
        character.height == "172"
        character.mass == "77"
        character.hairColor == "blond"
        character.skinColor == "fair"
        character.eyeColor == "blue"
        character.birthYear == "19BBY"
        character.gender == "male"
        character.homeworld.name == "Tatooine"
        character.starships.find {it.name == "Imperial shuttle"}
        character.starships.find {it.name == "X-wing"}
    }

    def "should get character by id return 404 if not found"() {
        when:
        def response = mockMvc.perform(getCharacterById(12L)).andReturn().response

        then: "status is not found"
        response.status == HttpStatus.NOT_FOUND.value()

        and: "message is valid"
        response.getContentAsString() == "Could not find entity with id: " + 12
    }

    @Unroll
    def "should get characters page"() {
        when:
        def response = mockMvc.perform(getCharactersPage(page)).andReturn().response

        then: "status is ok"
        response.status == HttpStatus.OK.value()

        and: "response body is ok"
        def pageMap = objectMapper.readValue(response.getContentAsString(), Map.class)
        pageMap.get("count") as Long == 11L
        pageMap.get("pages") as Integer == 2
        def elements = pageMap.get("elements") as List<CharacterModel>
        elements.size() == size

        where:
        page | size
        0    | 10
        1    | 1
    }

    private static MockHttpServletRequestBuilder getCharacterById(Long id) {
        return get(BASE_URL + "/" + id)
    }

    private static MockHttpServletRequestBuilder getCharactersPage(int page) {
        return get(BASE_URL)
            .param("page", String.valueOf(page))
    }
}

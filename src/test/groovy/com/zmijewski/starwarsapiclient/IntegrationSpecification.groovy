package com.zmijewski.starwarsapiclient

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@Testcontainers
class IntegrationSpecification extends Specification {

    @Shared
    static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer()
            .withDatabaseName("test")

    static {
        postgreSQLContainer.start()
        System.setProperty("db.testcontainer.username", postgreSQLContainer.username)
        System.setProperty("db.testcontainer.password", postgreSQLContainer.password)
        System.setProperty("db.testcontainer.url", postgreSQLContainer.jdbcUrl)
    }

    @Autowired
    protected MockMvc mockMvc

    @Autowired
    protected ObjectMapper objectMapper

}

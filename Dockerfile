FROM openjdk:11
COPY build/libs/star-wars-api-client*.jar star-wars-api-client.jar
ENTRYPOINT ["java", "-Duser.timezone=Europe/Warsaw", "-jar", "/star-wars-api-client.jar"]
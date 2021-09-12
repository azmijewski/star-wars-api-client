#Opis Aplikacji
Aplikacja na starcie pobiera dane dotyczące postaci, pojazdów i planet z SWAPI i zapisuje je we własnej bazie danych. Dane te są aktualizowane co godzinę. Aplikacja wystawia również własne API umożliwiające pobranie danych na temat postaci, ich pojazdów i planet z których pochodzą.

#Instalacja
Środowisko deweloperskie wymaga uruchomienia kontenera dockerowego z bazą danych. W folderze development znajduje się docker-compose, który uruchamia bazę. Aplikację uruchamiamy z profilem local.

#Technologie użyte w projekcie
* Java 11
* Spring Boot
* OpenFeign
* PostgeSQL
* Flyway
* Swagger

#Dokumentacja
Dokumentacja API została stworzona przy pomocy Swaggera i jest dostępna pod endpointem: /swagger-ui.html.
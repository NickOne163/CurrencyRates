Найстройка:
В Файле application.properties
1. Адреса внешних сервисов: "giphyUrl" и "openExchangeUrl"
2. Ключи для использования API: "exchangeRatesId" и "giphyId"
3. Валюту по отношению к которой смотрится курс: "symbols"


Сборка: 
1. Собрать проект командой: gradle build
2. Создать Docker Image с помощью команды: ./gradlew bootBuildImage --imageName=springio/exchange-rates
3. Создать и запустить Docker контейнер с помощью compose файла командой: docker-compose up -d


Чтобы посмотреть актуальную гифку  использовать url http://localhost:8080/currency/get

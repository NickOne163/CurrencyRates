Найстройка:
В Файле application.properties указать адреса внешних сервисов, ключи для использования API и валюту по отношению к которой смотрится курс,


Сборка: 
1. Собрать проект командой: gradle build
2. Создать Docker Image с помощью команды: ./gradlew bootBuildImage --imageName=springio/exchange-rates
3. Создать и запустить Docker контейнер с помощью compose файла командой: docker-compose up -d

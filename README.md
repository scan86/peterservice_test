## Описание

* Простой rest-сервис на spring boot, который на запрос /ping возвращает json с pong, timestamp и version. 

## Структура папок

* src — java-код
* rpm/rpmbuild — jar, rpm spec, 2е собранные rpm разных версий (чтоб проверить upgrade) и остальные файлы для сборки rpm

## Сборка

* Потребуется maven 3.2 и jdk 8.
* Собирается так:
`mvn clean verify`

## Сборака rpm

* `rpmbuild --clean -v -ba pingservice.spec`


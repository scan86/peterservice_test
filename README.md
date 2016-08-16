## Описание

* Простой rest-сервис на spring boot, который на запрос /ping возвращает json с pong, timestamp и version. 

* Для реализации задания, было решено использовать функционал spring boot, который позволяет создавать т. н. executable jar в режиме service (режиме service - чтоб не проверял «симлинк я или нет» при старте) Вот настройки:
```xml
<plugin>
   <groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-maven-plugin</artifactId>
   <configuration>
      <executable>true</executable>
      <embeddedLaunchScriptProperties>
         <mode>service</mode>
      </embeddedLaunchScriptProperties>
   </configuration>
</plugin>
```

* Для переопределения tcp-порта на котором сервис будет принимать соединения, нужно добавить следующe строку в файл /etc/sysconfig/pingservice.

`export RUN_ARGS="--server.port=8888"`

* Переменная RUN_ARGS обрабатывается сгенерённым init-скриптом расположенным в начале jar-файла и добавляет значение в строку запуска. Затем значение свойства server.port перекроет дефолтное значение в application.properties внутри jar.
Так же через RUN_ARGS можно указать путь к внешнему application.properties (через —spring.config.location), полностью переопределив его содержимое.

* Для запуска требуется java runtime 1.8. Поиск сперва в JAVA_HOME, затем в PATH.


## Структура папок

* src — java-код
* rpm/rpmbuild — jar, rpm spec, 2е собранные rpm разных версий (чтоб проверить upgrade) и остальные файлы для сборки rpm

## Сборка

* Потребуется maven 3.2 и jdk 8.
* Собирается так:
`mvn clean verify`

## Сборака rpm

* `rpmbuild --clean -v -ba pingservice.spec`




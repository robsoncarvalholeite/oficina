# IntegraLabs Oficina - API
The simple ERP for manufactory business.

> Projeto criado com o intuito de otimizar algumas técnicas de desenvolvimento ágil e gestão de projetos envolvendo tecnologias como Spring Boot, Java 8, Vue.js, AWS PaaS entre outras siglas do Hype.

## Setup

``` bash
# Install the maven dependencies
$ mvn clean compile -U

# For Test
$ mvn clean test

# Package Jar file without tests
$ mvn clean package -DskipTests

# Server Start http://localhost:8080/api/
$ java -jar target/oficina-*.jar

# Access Ping
$ curl http://localhost:8080/api/ping
>> eg response: now: Wed Aug 16 15:47:04 BRT 2017, UUID: f4626053-9366-467b-81b3-779e105fe2a1
or
Open Browser on http://localhost:8080/ping
```
Robson Leite 8)

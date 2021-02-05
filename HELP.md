# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.1/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.1/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.1/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.1/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.4.1/reference/htmlsingle/#production-ready)
* [Spring cache abstraction](https://docs.spring.io/spring-boot/docs/2.4.1/reference/htmlsingle/#boot-features-caching)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Caching Data with Spring](https://spring.io/guides/gs/caching/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

## Actuators
* [Chuck Norris - Custom Actuator](https://springframework.guru/chuck-norris-for-spring-boot-actuator/) \
_compile group: 'guru.springframework', name: 'chuck-norris-for-actuator', version: '0.0.2'_
* [Chuck Norris - Actuator Code Library](https://github.com/springframeworkguru/chuck-norris-for-actuator)

* [Git Details - Add Git Info](https://github.com/n0mer/gradle-git-properties) \
** _Using Plugin:** id "com.gorylenko.gradle-git-properties" version "2.2.4"_ \
** _Actuator Class:** TotalUsersInfoContributor_

## Test Plugin
* [Test Logger Plugin](https://github.com/radarsh/gradle-test-logger-plugin) \
_id 'com.adarshr.test-logger' version '2.1.1'_



## Enity Relationships and Associations
* [Spring JPA - Many-To-Many](https://www.baeldung.com/spring-data-rest-relationships)
* [JPA - Many-To-Many](https://www.baeldung.com/jpa-many-to-many)
* [JPA - Many-To-Many Using Composite]()\
Article-Authors
* [JPA - Many-To-Many Using Composite Embedded](https://www.baeldung.com/spring-jpa-embedded-method-parameters) \
Article-Rating-Webuser \
Only 1 rating per (article_id/webuser_id) - Composite Key \
  - User can post ONLY SINGLE rating per ArticleId/WebuserId
* [JPA - Many-To-Many (As a seperate Entity)]     
Article-Comment-WebUser \
Can have m comments per (article_id/webuser_id) - 
  - User can post MULTIPLE comments per ArticleId/WebuserId
    

####ToDo
* Fix Cascade Delete \
* Create REST interface \
* Update REST interface
* Using Profile
* [Request List](https://courses.springframework.guru/p/ready-for-production-with-spring-boot-actuator)

#### APIs

---
GET http://localhost:8080/articles \
GET http://localhost:8080/articles?startTime=15:10&endTime=20:00 \
GET http://localhost:8080/articles?creationDateTime=03-15-2018 \
GET http://localhost:8080/articles/1

---

POST http://localhost:8080/articles \

{
    "id": 6,
    "publicationDate": "01-11-2018",
    "publicationTime": "10:00:00",
    "creationDateTime": "01-04-2018 17:30:00",
    "title": "U.S Economy Is Improving Faster Than Expected, Budget Office Says"
}

PUT http://localhost:8080/articles/1 

{
    "publicationDate": "01-11-2018",
    "publicationTime": "10:00:00",
    "creationDateTime": "01-04-2018 17:30:00",
    "title": "U.S Economy Is Improving Faster Than Expected, Budget Office Says"
}
---
DELETE http://localhost:8080/articles/1

---
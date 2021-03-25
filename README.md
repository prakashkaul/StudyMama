# StudyMama
NUS-ISS Masters of Technology
Architecturing Software Solutions
Practice Module Project

**IDE:** Eclipse IDE 2021‑03 https://www.eclipse.org/downloads/

**Database:**  MySQL Community https://dev.mysql.com/downloads/installer/

**API Tester:** Postman https://www.postman.com/downloads/

**Language:** Java SE Development Kit 8u281 https://www.oracle.com/sg/java/technologies/javase/javase-jdk8-downloads.html

Frameworks
-
SpringBoot 2.4.4
https://start.spring.io/

Dependencies
```
Spring Web
Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.

Spring Security
Highly customizable authentication and access-control framework for Spring applications.

JSON Web Token Security
JSON Web Tokens are an open, industry standard RFC 7519 method for representing claims securely between two parties.

Spring Data JPA
Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate

MySQL Driver
MySQL JDBC and R2DBC driver.
```

MySQL Setup
-

**Schema**
```
CREATE SCHEMA `new_schema` ;
```

**User Table**
```
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
```

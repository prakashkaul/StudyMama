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
MySQL is an open-source relational database management system.

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

ElasticSearch
-
Elasticsearch is a search engine based on the Lucene library. It provides a distributed, multitenant-capable full-text search engine with an HTTP web interface and schema-free JSON documents.
https://www.elastic.co/downloads/elasticsearch

1. Run elastisearch.bat in bin folder.
2. http://localhost:9200/

Kibana
-
Kibana is a data visualization dashboard for Elasticsearch. It provides visualization capabilities on top of the content indexed on an Elasticsearch cluster.
https://www.elastic.co/downloads/kibana

1. Go to kibana.yml in the config folder.
2. Uncomment line -- elasticsearch.url: "http://localhost:9200"
3. Run kibana.bat in the bin folder.
4. http://localhost:5601/

Logstash
-
Logstash is a free and open server-side data processing pipeline that ingests data from a multitude of sources, transforms it, and then sends it to your favorite "stash."
https://www.elastic.co/downloads/logstash



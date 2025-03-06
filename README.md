first do you need to start docker, docker run in port 8000 if you have it occupied change it in docker-compose.yml , java app port run in port 4500,when you get up the database you can run the projecto to create the database if it doenst exist
it will create it self, the data base name is :university
The project contains 5 classes representing different entities.
Ensure the JPA annotations (like @OneToMany, @ManyToOne, @JoinColumn) are correctly configured — otherwise, the app may fail to run properly.
be care full with the mapping because is you use it wrong it would work.
to run the app, just run DemoApplication
use postman or another 
its maded in maven, jdprepositor, Spring Web kit,Spring Data JPA, Spring Boot Dev Tools, Spring web are the dependencies of the proyect
each class have 4 methond , findAll, Post,Delete and Put


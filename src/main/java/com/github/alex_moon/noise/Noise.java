package com.github.alex_moon.noise;

import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.rest.SpringCypherRestGraphDatabase;

@SpringBootApplication
@EnableNeo4jRepositories
public class Noise extends Neo4jConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(Noise.class, args);
    }

    public Noise() {
        setBasePackage("com.github.alex_moon.noise");
    }

    @Bean()
    public GraphDatabaseService graphDatabaseService() {
        return new SpringCypherRestGraphDatabase("http://127.0.0.1:7474/db/data", "neo4j", "fuck");
    }
}

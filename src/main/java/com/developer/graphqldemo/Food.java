package com.developer.graphqldemo;

import io.leangen.graphql.annotations.GraphQLQuery;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class Food {

    @Id @GeneratedValue
    @GraphQLQuery(name = "id", description = "A food's id")
    private UUID id;
    @GraphQLQuery(name = "name", description = "A food's name")
    private String name;
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExpiredFood{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
    }

}

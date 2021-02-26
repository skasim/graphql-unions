package com.developer.graphqldemo;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.GraphQLUnion;
import io.leangen.graphql.annotations.types.GraphQLType;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@GraphQLApi
@GraphQLType(name = "ExpiredService")
public class ExpiredService {

    private final ExpiredRepository expiredRepository;
    public ExpiredService(ExpiredRepository expiredRepository) {
        this.expiredRepository = expiredRepository;
    }

    @GraphQLQuery(name = "expiredFoods") // READ ALL
    public List<Expired> getExpiredFoods() {
        return expiredRepository.findAll();
    }

    @GraphQLQuery(name = "expiredFood") // READ BY ID
    public Optional<Expired> getExpiredFoodById(@GraphQLArgument(name = "id") UUID id) {
        return expiredRepository.findById(id);
    }

//    @GraphQLQuery(name = "foodOrExpired") // READ BY ID
//    public @GraphQLUnion(name = "result") Optional<Expired> getExpiredById(@GraphQLArgument(name = "id") UUID id) {
//        return expiredRepository.findById(id);
//    }

    @GraphQLMutation(name = "saveExpiredFood") // CREATE
    public Expired saveExpiredFood(@GraphQLArgument(name = "food") Expired food) {
        return expiredRepository.save(food);
    }

    @GraphQLMutation(name = "deleteExpiredFood") // DELETE
    public void deleteExpiredFood(@GraphQLArgument(name = "id") UUID id) {
    }

}

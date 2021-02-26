package com.developer.graphqldemo;

import io.leangen.graphql.annotations.*;
import io.leangen.graphql.annotations.types.GraphQLType;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@GraphQLApi
@GraphQLType(name = "FoodService")
public class FoodService {
    private final FoodRepository foodRepository;
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @GraphQLQuery(name = "foods") // READ ALL
    public List<Food> getFoods() {
        return foodRepository.findAll();
    }

    @GraphQLQuery(name = "food") // READ BY ID
    public Optional<Food> getFoodById(@GraphQLArgument(name = "id") UUID id) {
        return foodRepository.findById(id);
    }

//    @GraphQLQuery(name = "foodOrExpired") // READ BY ID
//    public @GraphQLUnion(name = "result") Optional<Food> getFoodById(@GraphQLArgument(name = "id") UUID id) {
//        return foodRepository.findById(id);
//    }

    @GraphQLMutation(name = "saveFood") // CREATE
    public Food saveFood(@GraphQLArgument(name = "food") Food food) {
        return foodRepository.save(food);
    }

    @GraphQLMutation(name = "deleteFood") // DELETE
    public void deleteFood(@GraphQLArgument(name = "id") Long id) {
    }
}
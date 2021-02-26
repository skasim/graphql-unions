package com.developer.graphqldemo;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.GraphQLUnion;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@GraphQLApi
public class UnionService {

    private final ExpiredRepository expiredRepository;
    private final FoodRepository foodRepository;

    public UnionService (ExpiredRepository expiredRepository, FoodRepository foodRepository) {
        this.expiredRepository = expiredRepository;
        this.foodRepository = foodRepository;
    }

    @GraphQLQuery(name = "foodOrExpired") // READ BY ID
    public @GraphQLUnion(name = "result") Optional<Food> getFoodById(@GraphQLArgument(name = "id") UUID id) {
        return foodRepository.findById(id);
    }

    @GraphQLQuery(name = "foodOrExpired") // READ BY ID
    public @GraphQLUnion(name = "result") Optional<Expired> getExpiredById(@GraphQLArgument(name = "id") UUID id) {
        return expiredRepository.findById(id);
    }

}

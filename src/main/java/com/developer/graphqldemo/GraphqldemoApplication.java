package com.developer.graphqldemo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class GraphqldemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqldemoApplication.class, args);
	}

	@Bean
	ApplicationRunner init(FoodService foodService, ExpiredService expiredService) {
		return args -> {
			Stream.of("Pizza", "Spam", "Eggs", "Avocado").forEach(name -> {
				Food food = new Food();
				food.setId(UUID.randomUUID());
				food.setName(name);
				foodService.saveFood(food);
			});
			foodService.getFoods().forEach(System.out::println);

			Stream.of("Lasagna", "Milk").forEach(name -> {
				Expired expired = new Expired();
				expired.setId(UUID.randomUUID());
				expired.setName(name);
				expiredService.saveExpiredFood(expired);
			});
		};
	}

}

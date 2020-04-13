package com.orderManagement.api.configuration;

import com.orderManagement.api.model.Order;
import com.orderManagement.api.repository.OrderRepository;
import com.orderManagement.api.model.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j //@Slf4j is a Lombok annotation to autocreate an Slf4j-based LoggerFactory as log
public class loadDataBase {

    /**
     * Spring Boot will run ALL CommandLineRunner beans once the application context is loaded
     * in order to initialize the database with somme dummy data
     * @param orderRepository the {@link OrderRepository}
     * @return a {@link CommandLineRunner}
     */
    @Bean
    CommandLineRunner initDataBase( OrderRepository orderRepository) {
        return args -> {
            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));
            orderRepository.findAll().forEach(order -> log.info("Preloaded " + order));
        };
    }
}

package com.shashi.reactive;

import com.shashi.reactive.controller.Employee;
import com.shashi.reactive.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveApplication.class, args);
    }

    @Bean
    CommandLineRunner employees(EmployeeRepository employeeRepository) {
        return args -> {
            employeeRepository
                    .deleteAll()
                    .subscribe(null, null, () -> {
                        Stream.of(
                                new Employee(UUID.randomUUID().toString(), "shashi", "20000000"),
                                new Employee(UUID.randomUUID().toString(), "kumar", "40000000"),
                                new Employee(UUID.randomUUID().toString(), "selva", "60000000"),
                                new Employee(UUID.randomUUID().toString(), "Raj", "80000000"))
                                .forEach(employee ->
                                        employeeRepository.save(employee)
                                                .subscribe(emp -> System.out.println(emp)));
                    });
        };
    }

}

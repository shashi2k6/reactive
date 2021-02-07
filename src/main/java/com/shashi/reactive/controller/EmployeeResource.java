package com.shashi.reactive.controller;

import com.shashi.reactive.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeResource {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public Flux<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Employee> getById(@PathVariable final String id) {
        return employeeRepository.findById(id);
    }


    @GetMapping("/{id}/events")
    public Flux<EmployeeEvent> getEvents(@PathVariable final String id) {
        return employeeRepository.findById(id)
                .flatMapMany(employee -> {
                    Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));
                    Flux<EmployeeEvent> employeeEventFlux =
                            Flux.fromStream(Stream.generate(()->new EmployeeEvent(employee,new Date())));
                           return Flux.zip(interval,employeeEventFlux)
                                    .map(objects -> objects.getT2());
                });
    }


}

package com.shashi.reactive.controller;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

public class EmployeeEvent {

    private Employee employee;
    private Date date;

    public EmployeeEvent(Employee employee, Date date) {
        this.employee = employee;
        this.date = date;
    }

    public EmployeeEvent() {
    }
}

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEvent that = (EmployeeEvent) o;
        return Objects.equals(employee, that.employee) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, date);
    }

    @Override
    public String toString() {
        return "EmployeeEvent{" +
                "employee=" + employee +
                ", date=" + date +
                '}';
    }
}

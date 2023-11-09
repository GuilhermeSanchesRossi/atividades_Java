package util;

import models.Employee;

import java.util.function.Predicate;

public class salaryPredicate implements Predicate<Employee> {

    public Double criteria;

    public salaryPredicate(Double criteria) {
        this.criteria = criteria;
    }

    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= this.criteria;
    }
}
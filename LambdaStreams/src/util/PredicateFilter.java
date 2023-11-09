package util;

import models.Employee;

import java.util.function.Predicate;

public class PredicateFilter implements Predicate<Employee> {

    public Double criteria;

    public PredicateFilter(Double criteria) {
        this.criteria = criteria;
    }

    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= this.criteria;
    }
}

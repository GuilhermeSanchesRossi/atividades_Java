package util;

import models.Employee;

import java.util.function.Predicate;

public class namePredicate implements Predicate<Employee> {

    public char criteria;

    public namePredicate(char criteria) {
        this.criteria = criteria;
    }

    @Override
    public boolean test(Employee employee) {
        return employee.getName().charAt(0) == criteria;
    }
}

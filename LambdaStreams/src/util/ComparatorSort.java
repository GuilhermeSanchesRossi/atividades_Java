package util;

import models.Employee;

import java.util.Comparator;

public class ComparatorSort implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getEmail().compareTo(emp2.getEmail());
    }
}

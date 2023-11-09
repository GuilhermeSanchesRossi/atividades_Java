package main;

import models.Employee;
import util.ComparatorSort;
import util.PredicateFilter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            BufferedReader arq = new BufferedReader(new FileReader("C:\\Users\\guilh\\atividades_Java" +
                    "\\LambdaStreams\\externalFiles\\dadosEmployees.csv"));

            List<Employee> employeesList = new ArrayList<>();
            String employee = arq.readLine();
            while(employee != null) {
                String[] atributos = employee.split(",");
                Employee emp = new Employee(atributos[0], atributos[1], Double.parseDouble(atributos[2]));
                employeesList.add(emp);
                employee = arq.readLine();
            }

            Double salarioMin = 3000.0;
            List<Employee> newList = employeesList.stream().filter(new PredicateFilter(salarioMin)).
                    sorted(new ComparatorSort()).toList();
            newList.forEach(emp -> System.out.println(emp.getEmail()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

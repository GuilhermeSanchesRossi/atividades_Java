package main;

import models.Employee;
import util.ComparatorSort;
import util.namePredicate;
import util.salaryPredicate;

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
            Employee emp;
            while (employee != null) {
                String[] atributos = employee.split(",");
                emp = new Employee(atributos[0], atributos[1], Double.parseDouble(atributos[2]));
                employeesList.add(emp);
                employee = arq.readLine();
            }

            Double salarioMin = 3000.0;
            System.out.println("email dos funcionários em ordem alfabética que possuem salário maior que " + salarioMin);
            List<Employee> newList = employeesList.stream().filter(new salaryPredicate(salarioMin)).
                    sorted(new ComparatorSort()).toList();
            newList.forEach(emp1 -> System.out.println(emp1.getEmail()));

            char charInicial = 'M';
            System.out.println("soma dos salários dos funcionários cujos nomes começam com " + charInicial);
            Double accumulatedSalary = employeesList.stream().filter(new namePredicate(charInicial)).
                    map(e -> e.getSalary()).reduce(0.0, (sal1, sal2) -> sal1+sal2);
            System.out.println(accumulatedSalary);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

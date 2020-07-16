package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.newhrsystem.Employee;
import com.kodilla.patterns2.adapter.company.oldhrsystem.SalaryCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SalaryAdapter extends SalaryAdaptee implements SalaryCalculator {
    @Override
    public double TotalSalary(String[][] workers, double[] salaries) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < salaries.length; i++) {
            employees.add(new Employee(
                    workers[i][0],
                    workers[i][1],
                    workers[i][2],
                    new BigDecimal(salaries[i])
            ));
        }
        return calculateSalaries(employees).doubleValue();
    }
}

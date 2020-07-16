package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.api.CompanyNotFoundException;
import com.kodilla.hibernate.manytomany.facade.api.EmployeeNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchFacadeTestSuite {
    @Autowired
    private SearchFacade searchFacade;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void shouldSearchEmployeesBySentence() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarcksky = new Employee("Stephanie", "Clarcksky");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        employeeDao.save(johnSmith);
        int johnSmithId = johnSmith.getId();
        employeeDao.save(stephanieClarcksky);
        int stephanieClarckskyId = stephanieClarcksky.getId();
        employeeDao.save(lindaKovalsky);
        int lindaKovalskyId = lindaKovalsky.getId();

        //When
        List<Employee> employees = Collections.emptyList();
        try {
            employees = searchFacade.processFindEmployeesBySentence("%sky%");
        } catch (EmployeeNotFoundException e) {
            System.out.println(e);
        }

        //Then
        try {
            assertEquals(2, employees.size());
        } finally {
            //CleanUp
            employeeDao.deleteById(johnSmithId);
            employeeDao.deleteById(stephanieClarckskyId);
            employeeDao.deleteById(lindaKovalskyId);
        }
    }

    @Test
    public void shouldSearchCompaniesBySentence() {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMasters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMasters);
        int dataMastersId = dataMasters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //When
        List<Company> companies = Collections.emptyList();
        try {
            companies = searchFacade.processFindCompaniesBySentence("%re%");
        } catch (CompanyNotFoundException e) {
            System.out.println(e);
        }

        //Then
        try {
            assertEquals(2, companies.size());
        } finally {
            //CleanUp
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMastersId);
            companyDao.deleteById(greyMatterId);
        }
    }
}

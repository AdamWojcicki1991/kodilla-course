package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.api.CompanyNotFoundException;
import com.kodilla.hibernate.manytomany.facade.api.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchFacade {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CompanyDao companyDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchFacade.class);

    public List<Company> processFindCompaniesBySentence(String sentence) throws CompanyNotFoundException {
        LOGGER.info("Searching companies by sentence: " + sentence);
        List<Company> companies = companyDao.retrieveCompaniesBySentence(sentence);
        if (companies.isEmpty()) {
            LOGGER.info("No companies found by sentence: " + sentence);
            throw new CompanyNotFoundException("No companies found !");
        } else {
            LOGGER.info("Companies successfully found by sentence: " + sentence);
            return companies;
        }
    }

    public List<Employee> processFindEmployeesBySentence(String sentence) throws EmployeeNotFoundException {
        LOGGER.info("Searching employees by sentence: " + sentence);
        List<Employee> employees = employeeDao.retrieveEmployeesBySentence(sentence);
        if (employees.isEmpty()) {
            LOGGER.info("No employees found by sentence: " + sentence);
            throw new EmployeeNotFoundException("No employees found !");
        } else {
            LOGGER.info("Employees successfully found by sentence: " + sentence);
            return employees;
        }
    }
}

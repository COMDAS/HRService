package com.das.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.das.hr.db.entity.Company;
import com.das.hr.exception.ApplicationException;
import com.das.hr.service.CompanyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    CompanyService service;

    @RequestMapping( value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Company> getCompany(@RequestParam(value = "id", required = true) Long id)
            throws ApplicationException
    {
        log.info("GET: getCompany method in Company Controller is called for ID: " + id);
        Company company = service.get(id);
        return new ResponseEntity<Company>(company, HttpStatus.OK);
    }

    @RequestMapping( value = "/getall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<List<Company>> getAllCompany()
            throws ApplicationException
    {
        log.info("GET: getAllCompany method in Company Controller");
        List<Company> companies = service.getAll();
        return new ResponseEntity<List<Company>>(companies, HttpStatus.OK);
    }

    @RequestMapping( value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Boolean> delete(@RequestParam(value = "id", required = true) Long id)
            throws ApplicationException
    {
        log.info("GET: delete method in Company Controller is called for ID: " + id);
        service.delete(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

    @RequestMapping( value = "/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Company> create(@RequestParam(value = "name", required = true) String name)
            throws ApplicationException
    {
        log.info("GET: create method in Company Controller is called for name: " + name);
        Company company = new Company();
        company.setName(name);
        Company savedCompany = service.add(company);
        return new ResponseEntity<Company>(savedCompany, HttpStatus.OK);
    }
}

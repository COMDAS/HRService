package com.das.hr.service;

import com.das.hr.db.entity.Company;
import com.das.hr.db.repository.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Repository
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepo;

    @Transactional(readOnly=true)
    public List<Company> getAll() {
        return companyRepo.findAll();
    }

    @Transactional(readOnly=true)
    public Company get(Long id) {
        return companyRepo.findOne(id);
    }


    @Transactional
    public void delete(Long id) {
        companyRepo.delete(id);
    }

    @Transactional
    public Company add(Company company) {

        if ( company != null ) {
            company = companyRepo.saveAndFlush(company);
        }
        return company;
    }

}

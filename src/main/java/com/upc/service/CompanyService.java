package com.upc.service;

import com.upc.domain.node.Company;
import com.upc.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;


/**
 * @Author: Pan
 * @Date: 2019/4/1 20:09
 * @Description:
 **/
@Service
public class CompanyService {
    private final static Logger LOG = LoggerFactory.getLogger(CompanyService.class);

    private final CompanyRepository companyRepository;
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Transactional(readOnly = true)
    public Company findByShopName(String shopName){
        Company result = companyRepository.findByShopName(shopName);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<Company> findByShopNameLike(String shopName){
        Collection<Company>  result = companyRepository.findByShopNameLike(shopName);
        return result;
    }

    @Transactional(readOnly = true)
    public Iterable<Company> findAll(){
        Iterable<Company>  result = companyRepository.findAll();
        return result;
    }

    @Transactional(readOnly = true)
    public List<Company> findByBrand(String name){
        List<Company> result = companyRepository.findByBrand(name);
        return result;
    }


}

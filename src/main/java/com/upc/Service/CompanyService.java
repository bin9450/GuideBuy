package com.upc.Service;

import com.upc.Domain.Node.Company;
import com.upc.Repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


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
}

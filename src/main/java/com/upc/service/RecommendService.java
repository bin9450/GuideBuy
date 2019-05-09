package com.upc.service;

import com.upc.domain.node.BrandStyleKind;
import com.upc.domain.node.Company;
import com.upc.domain.node.PhoneNode;
import com.upc.repository.RecommendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/5/6 11:14
 * @Description:
 **/

@Service
public class RecommendService {

    @Autowired
    RecommendRepository recommendRepository;

    @Transactional(readOnly = true)
    public List<Company> getRecommendCompany(int userId){
        List<Company> companies = recommendRepository.getUnionCompany(userId);
        List<BrandStyleKind> brandStyleKinds = recommendRepository.getUnionBrandStyle(userId);
        List<Company> otherCompanies = new ArrayList<>();

        if(companies != null){
            for(Company com:companies){
                List<Company> sameCompanies = recommendRepository.getOtherCompaniesOfTheSameType(com.getShopName());
                for (Company com2:sameCompanies){
                    boolean flag = true;
                    for (Company com3:companies){
                        if (com2.getShopName().equals(com3.getShopName())){
                            flag = false;
                            break;
                        }
                    }
                    if (flag == true){
                        otherCompanies.add(com2);
                    }
                }
            }
        }
        companies.addAll(otherCompanies);
        return companies;
    }

    @Transactional(readOnly = true)
    public List<PhoneNode> getRecommendPhone(int userId,String company){
        int avgBrowseTimesCom = recommendRepository.avgBrowseTimesCom(userId,company);
        List<PhoneNode> result = recommendRepository.moreBrowsePhone(userId,company,avgBrowseTimesCom);
        result.addAll(recommendRepository.browsePhone( company));
        return result;
    }

}

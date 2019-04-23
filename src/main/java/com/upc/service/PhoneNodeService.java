package com.upc.service;

import com.upc.domain.node.PhoneNode;
import com.upc.repository.PhoneNodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/2 8:52
 * @Description:
 **/
@Service
public class PhoneNodeService {

    private final static Logger LOG = LoggerFactory.getLogger(CompanyService.class);

    private final PhoneNodeRepository phoneNodeRepository;

    public PhoneNodeService(PhoneNodeRepository phoneNodeRepository) {
        this.phoneNodeRepository = phoneNodeRepository;
    }


    @Transactional(readOnly = true)
    public PhoneNode findByGoodName(String shopName){
        PhoneNode result = phoneNodeRepository.findByGoodName(shopName);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<PhoneNode> findByGoodNameLike(String shopName){
        Collection<PhoneNode>  result = phoneNodeRepository.findByGoodNameLike(shopName);
        return result;
    }

    @Transactional(readOnly = true)
    public PhoneNode findByGoodId(int goodId){
        PhoneNode result = phoneNodeRepository.findByGoodId(goodId);
        return result;
    }

    @Transactional(readOnly = true)
    public List<PhoneNode> findAllByPage(){
        int count = phoneNodeRepository.countAll() - 4;
        int skip= (int)(1+Math.random()*(count-1+1));
        int limit = 4;
        List<PhoneNode> result = phoneNodeRepository.findAllByPage(skip,limit);
        return result;
    }

    @Transactional(readOnly = true)
    public Iterable<PhoneNode> findAll(){
        return phoneNodeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<PhoneNode> findRandom(){
        int count = phoneNodeRepository.countAll() - 4;
        int i= (int)(1+Math.random()*(count-1+1));
        int j = i+30;
        //System.out.println(i);
        List<PhoneNode> result = phoneNodeRepository.findRandom(i,j);
        return result;
    }

    @Transactional(readOnly = true)
    public List<PhoneNode> findByBrandStyle(String name){
        int count = phoneNodeRepository.countByBrandStyle(name) - 6;
        int skip= (int)(1+Math.random()*(count-1+1));
        int limit = 6;
        List<PhoneNode> result = phoneNodeRepository.findByBrandStyleRom(name,skip,limit);
        return result;
    }


}

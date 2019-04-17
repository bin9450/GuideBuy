package com.upc.service;

import com.upc.domain.node.BrandStyle;
import com.upc.repository.BrandStyleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @Author: Pan
 * @Date: 2019/4/4 9:11
 * @Description:
 **/

@Service
public class BrandStyleService {
    private final BrandStyleRepository brandStyleRepository;

    public BrandStyleService(BrandStyleRepository brandStyleRepository) {
        this.brandStyleRepository = brandStyleRepository;
    }

    @Transactional(readOnly = true)
    public BrandStyle findByName(String name){
        BrandStyle result = brandStyleRepository.findByName(name);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<BrandStyle> findByNameLike(String name){
        Collection<BrandStyle> result = brandStyleRepository.findByNameLike(name);
        return result;
    }

    @Transactional(readOnly = true)
    public Iterable<BrandStyle> findAll(){
        Iterable<BrandStyle> result = brandStyleRepository.findAll();
        return result;
    }

}

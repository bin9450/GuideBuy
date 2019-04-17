package com.upc.service;

import com.upc.domain.node.ProductStyle;
import com.upc.repository.ProductStyleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @Author: Pan
 * @Date: 2019/4/4 10:01
 * @Description:
 **/

@Service
public class ProductStyleService {

    private  final ProductStyleRepository productStyleRepository;

    public ProductStyleService(ProductStyleRepository productStyleRepository) {
        this.productStyleRepository = productStyleRepository;
    }

    @Transactional(readOnly = true)
    public ProductStyle findByName(String name){
        ProductStyle result = productStyleRepository.findByName(name);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<ProductStyle> findByNameLike(String name){
        Collection<ProductStyle> result = productStyleRepository.findByNameLike(name);
        return result;
    }

    @Transactional(readOnly = true)
    public Iterable<ProductStyle> findAll(){
        Iterable<ProductStyle> result = productStyleRepository.findAll();
        return result;
    }

}

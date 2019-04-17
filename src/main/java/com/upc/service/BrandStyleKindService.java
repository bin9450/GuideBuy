package com.upc.service;

import com.upc.domain.node.BrandStyleKind;
import com.upc.repository.BrandStyleKindRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @Author: Pan
 * @Date: 2019/4/2 9:58
 * @Description:
 **/

@Service
public class BrandStyleKindService {
    private final BrandStyleKindRepository brandStyleKindRepository;

    public BrandStyleKindService(BrandStyleKindRepository brandStyleKindRepository) {
        this.brandStyleKindRepository = brandStyleKindRepository;
    }

    @Transactional(readOnly = true)
    public BrandStyleKind findByName(String name){
        BrandStyleKind result = brandStyleKindRepository.findByName(name);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<BrandStyleKind> findByNameLike(String name){
        Collection<BrandStyleKind> result = brandStyleKindRepository.findByNameLike(name);
        return result;
    }

    @Transactional(readOnly = true)
    public Iterable<BrandStyleKind> findAll(){
        Iterable<BrandStyleKind> result = brandStyleKindRepository.findAll();
        return result;
    }


/*
    @Transactional(readOnly = true)
    public Iterable<BrandStyleKind> findAllByThree(){
        Iterable<BrandStyleKind> result = brandStyleKindRepository.findAll();
        Iterator it = result.iterator();
        while(it.hasNext()){
            Object obj = it.next();

        }
        return result;
    }
*/

}

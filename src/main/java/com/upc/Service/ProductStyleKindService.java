package com.upc.Service;

import com.upc.Domain.Node.ProductStyleKind;
import com.upc.Repository.ProductStyleKindRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @Author: Pan
 * @Date: 2019/4/2 17:06
 * @Description:
 **/

@Service
public class ProductStyleKindService {

    private final ProductStyleKindRepository productStyleKindRepository;

    public ProductStyleKindService(ProductStyleKindRepository productStyleKindRepository) {
        this.productStyleKindRepository = productStyleKindRepository;
    }


    @Transactional(readOnly = true)
    public ProductStyleKind findByName(String name){
        ProductStyleKind result = productStyleKindRepository.findByName(name);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<ProductStyleKind> findByNameLike(String name){
        Collection<ProductStyleKind> result = productStyleKindRepository.findByNameLike(name);
        return result;
    }

    @Transactional(readOnly = true)
    public Iterable<ProductStyleKind> findAll(){
        Iterable<ProductStyleKind> result = productStyleKindRepository.findAll();
        return result;
    }

}

package com.upc.service;

import com.upc.repository.CollectionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author: Pan
 * @Date: 2019/4/17 18:21
 * @Description:
 **/

@Service
public class CollectionService {
    private final static Logger LOG = LoggerFactory.getLogger(CompanyService.class);

    private final CollectionRepository collectionRepository;

    public CollectionService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }
}

package com.upc.service;

import com.upc.repository.BuyRelationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author: Pan
 * @Date: 2019/4/18 18:45
 * @Description:
 **/

@Service
public class BuyRelationService {

    private final static Logger LOG = LoggerFactory.getLogger(BuyRelationService.class);

    private final BuyRelationRepository buyRelationRepository;

    public BuyRelationService(BuyRelationRepository buyRelationRepository) {
        this.buyRelationRepository = buyRelationRepository;
    }

}

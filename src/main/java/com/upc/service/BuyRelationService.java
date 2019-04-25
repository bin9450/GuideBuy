package com.upc.service;

import com.upc.domain.relations.BrowserRelation;
import com.upc.domain.relations.BuyRelation;
import com.upc.repository.BuyRelationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(readOnly = true)
    public Iterable<BuyRelation> findAll(){
        Iterable<BuyRelation> result = buyRelationRepository.findAll();
        return result;
    }

    @Transactional(readOnly = true)
    public List<BuyRelation> findByUserNodeId(int userId,int page){
        int size = 10;
        int skip = (page-1)*size;
        int limit = size;
        List<BuyRelation> result = buyRelationRepository.findByUserNodeId(userId,skip,limit);
        return result;
    }

    @Transactional(readOnly = true)
    public BuyRelation findByUserAndPhone(int userId,int goodId){
        BuyRelation result = buyRelationRepository.findByUserAndPhone(userId, goodId);
        return result;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void createBuyRelation(int userId,int goodId,String lastTime){
        buyRelationRepository.createBuyRelation(userId, goodId, lastTime);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void updateInfo(int userId,int goodId, String lastTime){
        buyRelationRepository.updateInfo(userId, goodId, lastTime);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void deleteByug( int userId,int goodId){
        buyRelationRepository.deleteByug(userId, goodId);
    }

}

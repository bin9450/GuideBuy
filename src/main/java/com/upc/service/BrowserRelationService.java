package com.upc.service;

import com.upc.domain.relations.BrowserRelation;
import com.upc.repository.BrowserRelationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Pan
 * @Date: 2019/4/16 9:56
 * @Description:
 **/

@Service
public class BrowserRelationService {

    private final static Logger LOG = LoggerFactory.getLogger(BrowserRelationService.class);

    private final BrowserRelationRepository browserRelationRepository;

    public BrowserRelationService(BrowserRelationRepository browserRelationRepository) {
        this.browserRelationRepository = browserRelationRepository;
    }

    @Transactional(readOnly = true)
    public Iterable<BrowserRelation> findAll(){
        Iterable<BrowserRelation> result = browserRelationRepository.findAll();
        return result;
    }

    @Transactional(readOnly = true)
    public Iterable<BrowserRelation> findByUserNodeId(int userId){
        Iterable<BrowserRelation> result = browserRelationRepository.findByUserNodeId(userId);
        return result;
    }

    @Transactional(readOnly = true)
    public BrowserRelation findByUserAndPhone(int userId,int goodId){
        BrowserRelation result = browserRelationRepository.findByUserAndPhone(userId,goodId);
        return result;
    }

    @Transactional(readOnly = true)
    public  Iterable<BrowserRelation> findByPhoneNodeId(int goodId){
        Iterable<BrowserRelation> result = browserRelationRepository.findByPhoneNodeId(goodId);
        return result;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void createBrowserRelation(int userId,int goodId,String lastTime){
        browserRelationRepository.createBrowserRelation(userId, goodId, lastTime);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void updateInfo(int userId,int goodId,String lastTime){
        browserRelationRepository.updateInfo(userId, goodId, lastTime);
    }


}

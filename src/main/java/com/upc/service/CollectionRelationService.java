package com.upc.service;

import com.upc.domain.relations.CollectionRelation;
import com.upc.repository.CollectionRelationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/17 18:21
 * @Description:
 **/

@Service
public class CollectionRelationService {
    private final static Logger LOG = LoggerFactory.getLogger(CompanyService.class);

    private final CollectionRelationRepository collectionRelationRepository;

    public CollectionRelationService(CollectionRelationRepository collectionRelationRepository) {
        this.collectionRelationRepository = collectionRelationRepository;
    }

    @Transactional(readOnly = true)
    public Iterable<CollectionRelation> findAll(){
        Iterable<CollectionRelation> result =collectionRelationRepository.findAll();
        return result;
    }

    @Transactional(readOnly = true)
    public List<CollectionRelation> findByUserNodeId(int userId){
        List<CollectionRelation> result = collectionRelationRepository.findByUserNodeId(userId);
        return result;
    }

    @Transactional(readOnly = true)
    public CollectionRelation findByUserAndPhone(int userId,int goodId){
        CollectionRelation result = collectionRelationRepository.findByUserAndPhone(userId,goodId);
        return result;
    }

    @Transactional(readOnly = true)
    public  List<CollectionRelation> findByPhoneNodeId(int goodId){
        List<CollectionRelation> result = collectionRelationRepository.findByPhoneNodeId(goodId);
        return result;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void createBrowserRelation(int userId,int goodId,String lastTime){
        collectionRelationRepository.createCollectionRelation(userId, goodId, lastTime);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void updateInfo(int userId,int goodId,String lastTime){
        collectionRelationRepository.updateInfo(userId, goodId, lastTime);
    }

}

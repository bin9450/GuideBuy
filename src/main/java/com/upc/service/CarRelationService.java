package com.upc.service;

import com.upc.domain.relations.CarRelation;
import com.upc.repository.CarRelationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @Author: Pan
 * @Date: 2019/4/18 16:32
 * @Description:
 **/

@Service
public class CarRelationService {

    private final static Logger LOG = LoggerFactory.getLogger(CarRelationService.class);

    private final CarRelationRepository carRelationRepository;

    public CarRelationService(CarRelationRepository carRelationRepository) {
        this.carRelationRepository = carRelationRepository;
    }

    @Transactional(readOnly = true)
    public Iterable<CarRelation> findAll(){
        Iterable<CarRelation> result =carRelationRepository.findAll();
        return result;
    }

    @Transactional(readOnly = true)
    public List<CarRelation> findByUserNodeId(int userId,int page){
        int size = 10;
        int skip = (page-1)*size;
        int limit = size;
        List<CarRelation> result = carRelationRepository.findByUserNodeId(userId,skip,limit);
        return result;
    }

    @Transactional(readOnly = true)
    public CarRelation findByUserAndPhone(int userId,int goodId){
        CarRelation result = carRelationRepository.findByUserAndPhone(userId,goodId);
        return result;
    }

    @Transactional(readOnly = true)
    public  List<CarRelation> findByPhoneNodeId(int goodId){
        List<CarRelation> result = carRelationRepository.findByPhoneNodeId(goodId);
        return result;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void createCarRelation(int userId,int goodId,String carTime){
        carRelationRepository.createCarRelation(userId, goodId, carTime);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void updateInfo(int userId,int goodId,String carTime){
        carRelationRepository.updateInfo(userId, goodId, carTime);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void deleteRelation(int userId,int goodId){
        carRelationRepository.deleteRelation(userId, goodId);
    }

}

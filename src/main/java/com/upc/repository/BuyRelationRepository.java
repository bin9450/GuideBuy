package com.upc.repository;

import com.upc.domain.relations.BuyRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Pan
 * @Date: 2019/4/18 18:44
 * @Description:
 **/

@Repository
public interface BuyRelationRepository extends Neo4jRepository<BuyRelation,Long>{

}

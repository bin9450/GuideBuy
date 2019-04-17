package com.upc.repository;

import com.upc.domain.relations.CollectionRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Pan
 * @Date: 2019/4/17 18:19
 * @Description:
 **/

@Repository
public interface CollectionRelationRepository extends Neo4jRepository<CollectionRelation,Long>{

}

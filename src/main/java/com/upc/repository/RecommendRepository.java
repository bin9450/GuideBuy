package com.upc.repository;

import com.upc.domain.node.PhoneNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/5/6 11:14
 * @Description:
 **/

@Repository
public interface RecommendRepository  {

    @Query("/")
    List<PhoneNode> find();

}

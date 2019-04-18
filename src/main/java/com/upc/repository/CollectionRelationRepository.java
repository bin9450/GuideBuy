package com.upc.repository;

import com.upc.domain.relations.CollectionRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/17 18:19
 * @Description:
 **/

@Repository
public interface CollectionRelationRepository extends Neo4jRepository<CollectionRelation,Long>{

    @Query("match p=(n:UserNode)-[c:COLLECT_GOOD]->(m:Phone)" +
            "where n.user_id = {userId} " +
            "return p order by b.CollectTime desc")
    List<CollectionRelation> findByUserNodeId(@Param("userId") int userId);

    @Query("match p=(n:UserNode)-[c:COLLECT_GOOD]->(m:Phone) " +
            "where n.user_id = {userId} and  m.good_id = {goodId} " +
            "return p")
    CollectionRelation findByUserAndPhone(@Param("userId") int userId,@Param("goodId") int goodId);

    @Query("match p=(n:UserNode)-[c:COLLECT_GOOD]->(m:Phone) " +
            "where m.good_id = {goodId} return p")
    List<CollectionRelation> findByPhoneNodeId(@Param("goodId") int goodId);

    @Query("MATCH (n:UserNode),(m:Phone) " +
            "where n.user_id = {userId} and m.good_id = {goodId} " +
            "create (n)-[c:COLLECT_GOOD{CollectTime:{collectTime} }]->(m)")
    void createCollectionRelation(@Param("userId") int userId,@Param("goodId") int goodId,
                               @Param("collectTime") String collectTime);

    @Query("MATCH (n:UserNode)-[c:COLLECT_GOOD]->(m:Phone)" +
            " where n.user_id = {userId} and m.good_id = {goodId} " +
            "set b.CollectTime = {collectTime} ")
    void updateInfo(@Param("userId") int userId,@Param("goodId") int goodId,
                    @Param("collectTime") String collectTime);


}

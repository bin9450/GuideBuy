package com.upc.repository;

import com.upc.domain.relations.CarRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/18 16:31
 * @Description:
 **/

@Repository
public interface CarRelationRepository extends Neo4jRepository<CarRelation,Long>{

    @Query("match p=(n:UserNode)-[c:CAR_GOOD]->(m:Phone)" +
            "where n.user_id = {userId} " +
            "return p order by c.CarTime desc skip{skip} limit{limit}")
    List<CarRelation> findByUserNodeId(@Param("userId") int userId,
                                       @Param("skip") int skip,
                                       @Param("limit") int limit);

    @Query("match p=(n:UserNode)-[c:CAR_GOOD]->(m:Phone) " +
            "where n.user_id = {userId} and  m.good_id = {goodId} " +
            "return p")
    CarRelation findByUserAndPhone(@Param("userId") int userId,@Param("goodId") int goodId);

    @Query("match p=(n:UserNode)-[c:CAR_GOOD]->(m:Phone) " +
            "where m.good_id = {goodId} return p")
    List<CarRelation> findByPhoneNodeId(@Param("goodId") int goodId);

    @Query("MATCH (n:UserNode),(m:Phone) " +
            "where n.user_id = {userId} and m.good_id = {goodId} " +
            "create (n)-[c:CAR_GOOD{CarTime:{carTime} }]->(m)")
    void createCarRelation(@Param("userId") int userId,@Param("goodId") int goodId,
                                  @Param("carTime") String carTime);

    @Query("MATCH (n:UserNode)-[c:CAR_GOOD]->(m:Phone)" +
            " where n.user_id = {userId} and m.good_id = {goodId} " +
            "set c.CarTime = {carTime} ")
    void updateInfo(@Param("userId") int userId,@Param("goodId") int goodId,
                    @Param("carTime") String carTime);

    @Query("MATCH (n:UserNode)-[c:CAR_GOOD]->(m:Phone)" +
            " where n.user_id = {userId} and m.good_id = {goodId} " +
            "delete c")
    void deleteRelation(@Param("userId") int userId,@Param("goodId") int goodId);


}

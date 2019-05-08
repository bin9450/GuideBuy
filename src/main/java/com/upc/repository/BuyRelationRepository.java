package com.upc.repository;

import com.upc.domain.relations.BuyRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/18 18:44
 * @Description:
 **/

@Repository
public interface BuyRelationRepository extends Neo4jRepository<BuyRelation,Long>{

    /**
     * fetch buying record data by user id
     * @param userId user id
     * @param skip page number
     * @param limit  page limit
     * @return List<BuyRelation>
     */
    @Query("match p=(n:UserNode)-[b:BUY_GOOD]->(m:Phone)" +
            "where n.user_id = {userId} " +
            "return p order by b.LastTime desc skip{skip} limit{limit}")
    List<BuyRelation> findByUserNodeId(@Param("userId") int userId,
                                       @Param("skip") int skip,
                                       @Param("limit") int limit);

    /**
     * fetch buying record data by user id and good id
     * @param userId user id
     * @param goodId good id
     * @return    BuyRelation
     */
    @Query("match p=(n:UserNode)-[b:BUY_GOOD]->(m:Phone) " +
            "where n.user_id = {userId} and  m.good_id = {goodId} " +
            "return p")
    BuyRelation findByUserAndPhone(@Param("userId") int userId,
                                   @Param("goodId") int goodId);

    /**
     * fetch buying record data by  good id
     * @param goodId good id
     * @return List<BuyRelation>
     */
    @Query("match p=(n:UserNode)-[b:BUY_GOOD]->(m:Phone) " +
            "where m.good_id = {goodId} return p")
    List<BuyRelation> findByPhoneNodeId(@Param("goodId") int goodId);

    /**
     * create buying record data by user id and good id
     * @param userId user id
     * @param goodId good id
     * @param lastTime   recent purchase time
     */
    @Query("MATCH (n:UserNode),(m:Phone) " +
            "where n.user_id = {userId} and m.good_id = {goodId} " +
            "create (n)-[b:BUY_GOOD{BuyTimes:1,LastTime:{lastTime} }]->(m)")
    void createBuyRelation(@Param("userId") int userId,@Param("goodId") int goodId,
                               @Param("lastTime") String lastTime);

    /**
     * update buying record data by user id and good id
     * @param userId user id
     * @param goodId good id
     * @param lastTime   recent purchase time
     */
    @Query("MATCH (n:UserNode)-[b:BUY_GOOD]->(m:Phone)" +
            " where n.user_id = {userId} and m.good_id = {goodId} " +
            "set b.BuyTimes = b.BuyTimes + 1 " +
            "set b.LastTime = {lastTime} ")
    void updateInfo(@Param("userId") int userId,@Param("goodId") int goodId,
                    @Param("lastTime") String lastTime);

    /**
     * delete buying record data by user id and good id
     * @param userId user id
     * @param goodId good id
     */
    @Query("match p=(n:UserNode)-[b:BUY_GOOD]->(m:Phone) " +
            "where n.user_id = {userId} and  m.good_id = {goodId} " +
            "delete b")
    void deleteByug(@Param("userId") int userId,@Param("goodId") int goodId);

}

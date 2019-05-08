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

    /**
     * fetch collection data by user id
     * @param userId user id
     * @param skip page number
     * @param limit page limit
     * @return  List<CollectionRelation>
     */
    @Query("match p=(n:UserNode)-[c:COLLECT_GOOD]->(m:Phone)" +
            "where n.user_id = {userId} " +
            "return p order by c.CollectTime desc skip {skip} limit {limit}")
    List<CollectionRelation> findByUserNodeId(@Param("userId") int userId,
                                              @Param("skip") int skip,
                                              @Param("limit") int limit);

    /**
     * fetch collection data by user id and good id
     * @param goodId good id
     * @param userId user id
     * @return  CollectionRelation
     */
    @Query("match p=(n:UserNode)-[c:COLLECT_GOOD]->(m:Phone) " +
            "where n.user_id = {userId} and  m.good_id = {goodId} " +
            "return p")
    CollectionRelation findByUserAndPhone(@Param("userId") int userId,
                                          @Param("goodId") int goodId);

    /**
     * fetch collection data by good id
     * @param goodId good id
     * @return  List<CollectionRelation>
     */
    @Query("match p=(n:UserNode)-[c:COLLECT_GOOD]->(m:Phone) " +
            "where m.good_id = {goodId} return p")
    List<CollectionRelation> findByPhoneNodeId(@Param("goodId") int goodId);

    /**
     * create collection data by user id and good id
     * @param  userId user id
     * @param goodId good id
     * @param collectTime operating time
     */
    @Query("MATCH (n:UserNode),(m:Phone) " +
            "where n.user_id = {userId} and m.good_id = {goodId} " +
            "create (n)-[c:COLLECT_GOOD{CollectTime:{collectTime} }]->(m)")
    void createCollectionRelation(@Param("userId") int userId,@Param("goodId") int goodId,
                               @Param("collectTime") String collectTime);
    /**
     * update collection data by user id
     * @param  userId id
     * @param goodId good id
     * @param collectTime operating time
     */
    @Query("MATCH (n:UserNode)-[c:COLLECT_GOOD]->(m:Phone)" +
            " where n.user_id = {userId} and m.good_id = {goodId} " +
            "set c.CollectTime = {collectTime} ")
    void updateInfo(@Param("userId") int userId,
                    @Param("goodId") int goodId,
                    @Param("collectTime") String collectTime);

    /**
     * delete collection data by user id
     * @param  userId id
     * @param goodId page number
     */
    @Query("MATCH (n:UserNode)-[c:COLLECT_GOOD]->(m:Phone)" +
            " where n.user_id = {userId} and m.good_id = {goodId} " +
            "delete c")
    void deleteRelation(@Param("userId") int userId,@Param("goodId") int goodId);


}

package com.upc.repository;

import com.upc.domain.relations.BrowserRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: Pan
 * @Date: 2019/4/16 9:03
 * @Description:
 **/

@Repository
public interface BrowserRelationRepository extends  Neo4jRepository<BrowserRelation,Long> {

    /**
     * fetch browse record data by user id
     * @param userId user id
     * @param skip page number
     * @param limit page limit
     * @return Iterable<BrowserRelation>
     */
    @Query("match p=(n:UserNode)-[b:BROWSE_GOOD]->(m:Phone)" +
                "where n.user_id = {userId} " +
            "return p order by b.LastTime desc skip{skip} limit{limit}")
    Iterable<BrowserRelation> findByUserNodeId(@Param("userId") int userId,
                                               @Param("skip") int skip,
                                               @Param("limit") int limit);

    /**
     * fetch browse record data by user id and good id
     * @param userId user id
     * @param goodId good id
     * @return BrowserRelation
     */
    @Query("match p=(n:UserNode)-[b:BROWSE_GOOD]->(m:Phone) " +
            "where n.user_id = {userId} and  m.good_id = {goodId} " +
            "return p")
    BrowserRelation findByUserAndPhone(@Param("userId") int userId,
                                       @Param("goodId") int goodId);

    /**
     * fetch browsing record data by good id
     * @param goodId good id
     * @return BrowserRelation
     */
    @Query("match p=(n:UserNode)-[b:BROWSE_GOOD]->(m:Phone) " +
            "where m.good_id = {goodId} return p")
    Iterable<BrowserRelation> findByPhoneNodeId(@Param("goodId") int goodId);

    /**
     * create browseing record data by user id and good id
     * @param userId user id
     * @param goodId page number
     * @param lastTime  recent browsing time
     */
    @Query("MATCH (n:UserNode),(m:Phone) " +
            "where n.user_id = {userId} and m.good_id = {goodId} " +
            "create (n)-[b:BROWSE_GOOD{BrowseTimes:1,LastTime:{lastTime} }]->(m)")
    void createBrowserRelation(@Param("userId") int userId,
                               @Param("goodId") int goodId,
                               @Param("lastTime") String lastTime);

    /**
     * update browseing record data by user id and good id
     * @param userId user id
     * @param goodId page number
     * @param lastTime  recent browsing time
     */
    @Query("MATCH (n:UserNode)-[b:BROWSE_GOOD]->(m:Phone)" +
            " where n.user_id = {userId} and m.good_id = {goodId} " +
            "set b.BrowseTimes = b.BrowseTimes + 1 " +
            "set b.LastTime = {lastTime}")
    void updateInfo(@Param("userId") int userId,@Param("goodId") int goodId,
                    @Param("lastTime") String lastTime);


}

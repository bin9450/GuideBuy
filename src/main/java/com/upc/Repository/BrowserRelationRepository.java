package com.upc.Repository;

import com.upc.Domain.Relations.BrowserRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/16 9:03
 * @Description:
 **/

@Repository
public interface BrowserRelationRepository extends  Neo4jRepository<BrowserRelation,Long> {

    @Query("match p=(n:UserNode)-[b:BROWSE_GOOD]->(m:Phone)" +
                "where n.user_id = {userId} " +
            "return p order by b.LastTime desc")
    Iterable<BrowserRelation> findByUserNodeId(@Param("userId") int userId);
//
    @Query("match p=(n:UserNode)-[b:BROWSE_GOOD]->(m:Phone) " +
            "where n.user_id = {userId} and  m.good_id = {goodId} " +
            "return p")
    BrowserRelation findByUserAndPhone(@Param("userId") int userId,@Param("goodId") int goodId);

    @Query("match p=(n:UserNode)-[b:BROWSE_GOOD]->(m:Phone) " +
            "where m.good_id = {goodId} return p")
    Iterable<BrowserRelation> findByPhoneNodeId(@Param("goodId") int goodId);

    @Query("MATCH (n:UserNode),(m:Phone) " +
            "where n.user_id = {userId} and m.good_id = {goodId} " +
            "create (n)-[b:BROWSE_GOOD{BrowseTimes:1,LastTime:{lastTime} }]->(m)")
    void createBrowserRelation(@Param("userId") int userId,@Param("goodId") int goodId,
                               @Param("lastTime") String lastTime);

    @Query("MATCH (n:UserNode)-[b:BROWSE_GOOD]->(m:Phone)" +
            " where n.user_id = {userId} and m.good_id = {goodId} " +
            "set b.BrowseTimes = b.BrowseTimes + 1 " +
            "set b.LastTime = {lastTime} ")
    void updateInfo(@Param("userId") int userId,@Param("goodId") int goodId,
                    @Param("lastTime") String lastTime);


}

package com.upc.repository;

import com.upc.domain.node.PhoneNode;
import com.upc.domain.node.UserNode;
import org.springframework.data.neo4j.annotation.Query;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/11 17:17
 * @Description:
 **/

@Repository
public interface UserNodeRepository extends Neo4jRepository<UserNode,Long> {

    UserNode findByNickName(@Param("nick_name") String nickName);
    Collection<UserNode> findByNickNameLike(@Param("nick_name") String nickName);

    @Query("match(n:UserNode) where n.user_id = {userId} return n")
    UserNode findByUserId(@Param("userId") int userId);

    @Query("create(n:UserNode{ user_id:{userId},nick_name:{nickName} })")
    void createUserNode(@Param("userId") int userId,@Param("nickName") String nickName);

    @Query("match p=(n:UserNode)-[b:Browser]->(m:Phone)" +
            "where n.user_id = {userId} return m")
    List<PhoneNode> findByUserNodeId(@Param("userId") int userId);

    @Query("match p=(n:UserNode)-[b:Browser]->(m:Phone) " +
            "where n.user_id = {userId} and  m.good_id = {goodId} " +
            "return b.BrowseTimes")
    int findBrowseTimes(@Param("userId") int userId,@Param("goodId") int goodId);

    @Query("match p=(n:UserNode)-[b:Browser]->(m:Phone) " +
            "where n.user_id = {userId} and  m.good_id = {goodId} " +
            "return b.LastTime")
    String findLastTime(@Param("userId") int userId,@Param("goodId") int goodId);

    @Query("match p=(n:UserNode)-[b:Browser]->(m:Phone) " +
            "where m.good_id = {goodId} return n")
    List<UserNode> findByPhoneNodeId(@Param("goodId") int goodId);

    @Query("create(n:UserNode{ user_id:{userId},nick_name:{nickName} })")
    void createBrowser(@Param("userId") int userId,@Param("nickName") String nickName);

}

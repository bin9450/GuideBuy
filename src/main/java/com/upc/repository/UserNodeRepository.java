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
    /**
     * fetch user data
     * @param nickName user nick name
     * @return user
     */
    UserNode findByNickName(@Param("nick_name") String nickName);

    /**
     * fetch some user data
     * @param nickName user nick name
     * @return user
     */
    Collection<UserNode> findByNickNameLike(@Param("nick_name") String nickName);

    /**
     * fetch  user data by user id
     * @param userId user id
     * @return user
     */
    @Query("match(n:UserNode) where n.user_id = {userId} return n")
    UserNode findByUserId(@Param("userId") int userId);

    /**
     * create  user node by user id
     * @param userId user id
     * @param nickName user nick name
     */
    @Query("create(n:UserNode{ user_id:{userId},nick_name:{nickName} })")
    void createUserNode(@Param("userId") int userId,@Param("nickName") String nickName);

    /**
     * fetch  phone data by user id
     * @param userId user id
     * @return  List<PhoneNode>
     */
    @Query("match p=(n:UserNode)-[b:Browser]->(m:Phone)" +
            "where n.user_id = {userId} return m")
    List<PhoneNode> findByUserNodeId(@Param("userId") int userId);

    /**
     * fetch  BrowseTimes data by user id and good id
     * @param userId user id
     * @param goodId good id
     * @return  BrowseTimes
     */
    @Query("match p=(n:UserNode)-[b:Browser]->(m:Phone) " +
            "where n.user_id = {userId} and  m.good_id = {goodId} " +
            "return b.BrowseTimes")
    int findBrowseTimes(@Param("userId") int userId,@Param("goodId") int goodId);

    /**
     * fetch  BrowseTimes data by user id and good id
     * @param userId user id
     * @param goodId good id
     * @return  BrowseTimes
     */
    @Query("match p=(n:UserNode)-[b:Browser]->(m:Phone) " +
            "where n.user_id = {userId} and  m.good_id = {goodId} " +
            "return b.LastTime")
    String findLastTime(@Param("userId") int userId,@Param("goodId") int goodId);

    /**
     * fetch  user data by good id
     * @param goodId good id
     * @return  List<UserNode>
     */
    @Query("match p=(n:UserNode)-[b:Browser]->(m:Phone) " +
            "where m.good_id = {goodId} return n")
    List<UserNode> findByPhoneNodeId(@Param("goodId") int goodId);

    /**
     * create user data by good id
     * @param userId user id
     *  @param nickName user nick name
     */
    @Query("create(n:UserNode{ user_id:{userId},nick_name:{nickName} })")
    void createBrowser(@Param("userId") int userId,@Param("nickName") String nickName);
    
}

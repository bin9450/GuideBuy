package com.upc.repository;

import com.upc.domain.node.PhoneNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/1 19:57
 * @Description:
 **/

@Repository
public interface PhoneNodeRepository extends Neo4jRepository<PhoneNode,Long> {

    PhoneNode findByGoodName(@Param("good_name") String good_name);

    Collection<PhoneNode> findByGoodNameLike(@Param("good_name") String good_name);

    @Query("MATCH (n:Phone) where n.good_id = {goodId} RETURN n")
    PhoneNode findByGoodId(@Param("goodId") int goodId);

    @Query("MATCH (n:Phone) " +
            "where n.good_id>={i} and n.good_id<={j}" +
            " RETURN n ORDER BY n.comment DESC")
    List<PhoneNode> findRandom(@Param("i") int i,@Param("j") int j);


    @Query("MATCH (n:Phone)" +
            " RETURN n" +
            " SKIP{skip} LIMIT{limit}")
     List<PhoneNode> findAllByPage(@Param("skip") int skip,@Param("limit") int limit);

    //根据厂商定位查询手机
    @Query("match (a:Brand_Style_Kind)-[re]->(b:Company)-[re2]->(c:Phone) " +
            "where a.name = {name} " +
            "return c skip {skip} limit {limit}")
    List<PhoneNode> findByBrandStyleRom(@Param("name") String name,
                                     @Param("skip") int skip,
                                     @Param("limit") int limit);

    @Query("match (a:Brand_Style_Kind)-[re]->(b:Company)-[re2]->(c:Phone) " +
            "where a.name = {name} " +
            "return count(c)")
    int countByBrandStyle(@Param("name") String name);

}

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

    /**
     * fetch phone data by good name
     * @param  goodName good name
     * @return  PhoneNode
     */
    PhoneNode findByGoodName(@Param("good_name") String goodName);

    /**
     * fetch phone data by good name according to fuzzy query
     * @param  goodName good name
     * @return  Collection<PhoneNode>
     */
    Collection<PhoneNode> findByGoodNameLike(@Param("good_name") String goodName);

    /**
     * fetch phone data by good id
     * @param  goodId good id
     * @return  <PhoneNode>
     */
    @Query("MATCH (n:Phone) where n.good_id = {goodId} RETURN n")
    PhoneNode findByGoodId(@Param("goodId") int goodId);

    /**
     * fetch phone data by range of good id
     * @param  i lower limit
     * @param  j upper limit
     * @return  List<PhoneNode>
     */
    @Query("MATCH (n:Phone) " +
            "where n.good_id>={i} and n.good_id<={j}" +
            " RETURN n ORDER BY n.comment DESC")
    List<PhoneNode> findRandom(@Param("i") int i,@Param("j") int j);

    /**
     * fetch phone data
     * @param  skip skip
     * @param  limit limit
     * @return  List<PhoneNode>
     */
    @Query("MATCH (n:Phone)" +
            " RETURN n ORDER BY n.comment DESC" +
            " SKIP{skip} LIMIT{limit}")
     List<PhoneNode> findAllByPage(@Param("skip") int skip,
                                   @Param("limit") int limit);
    /**
     * fetch number
     * @return  number of mobile phones
     */
    @Query("MATCH (n:Phone) RETURN count(n)")
    int countAll();

    /**
     * fetch phone data by Brand Style Kind name
     * @param  name Brand Style Kind name
     * @param  skip skip
     * @param  limit limit
     * @return  List<PhoneNode>
     */
    @Query("match (a:Brand_Style_Kind)-[re]->(b:Company)-[re2]->(c:Phone) " +
            "where a.name = {name} " +
            "return c order by toInt(c.comment) DESC " +
            "skip {skip} limit {limit}")
    List<PhoneNode> findByBrandStyleRom(@Param("name") String name,
                                     @Param("skip") int skip,
                                     @Param("limit") int limit);
    /**
     * fetch number by Brand Style Kind name
     * @param name Brand Style Kind name
     * @return  number of mobile phones
     */
    @SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
    @Query("match (a:Brand_Style_Kind)-[re]->(b:Company)-[re2]->(c:Phone) " +
            "where a.name = {name} " +
            "return count(c)")
    int countByBrandStyle(@Param("name") String name);

    /**
     * fetch related products data by phone name
     * @param searchName good name
     * @param skip page number
     * @param limit page limit
     * @return  number of mobile phones
     */
    @Query("match (co:Company)-[s:SELLING_WITH]->(ph:Phone) " +
            " where ph.good_name =~ {searchName} " +
            " return distinct ph as phone " +
            "order by ph.comment desc " +
            "skip {skip} limit {limit} " +
            " union " +
            "match (co2:Company)-[s2:SELLING_WITH]->(ph2:Phone) " +
            "where ph2.good_name =~ {searchName} " +
            "optional match (co2)-[s3:SELLING_WITH]->(ph3:Phone) " +
            "return distinct ph3 as phone " +
            "order by ph3.comment desc " +
            "skip {skip} limit {limit} ")
    List<PhoneNode> findByNameLike(@Param("searchName") String searchName,
                                   @Param("skip") int skip,
                                   @Param("limit") int limit);

    /**
     * update products comment
     * @param goodId good id
     * @param comment comment
     */
    @Query("match (p:Phone) " +
            "where p.good_id = {goodId} " +
            "set p.comment = toString(toInteger(p.comment) + {comment} ) ")
    void setComment(@Param("goodId") int goodId,
                    @Param("comment") int comment);


}

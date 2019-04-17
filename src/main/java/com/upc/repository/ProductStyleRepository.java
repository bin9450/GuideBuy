package com.upc.repository;

import com.upc.domain.node.ProductStyle;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @Author: Pan
 * @Date: 2019/4/4 9:58
 * @Description:
 **/

@Repository
public interface ProductStyleRepository extends Neo4jRepository<ProductStyle,Long> {

    ProductStyle findByName(@Param("name") String name);
    Collection<ProductStyle> findByNameLike(@Param("name") String name);

    /** 复杂条件查询未实现
     @Query(" MATCH p=(s:Packcode)-[rp:Pc_LINK_Pc*0..]->(subP:Packcode)" +
     "WHERE subP.packcodeNo = {packcodeNo} and all( x in rp where x.bindStatus= {bindStatus}  )" +
     "RETURN  p")
     List<ProductStyleKind> find(@Param("name") String name);

     */
}

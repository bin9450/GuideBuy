package com.upc.repository;

import com.upc.domain.node.BrandStyle;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @Author: Pan
 * @Date: 2019/4/4 8:49
 * @Description:
 **/

@Repository
public interface BrandStyleRepository extends Neo4jRepository<BrandStyle,Long> {

    /**
     * fetch data by name
     *
     * @param  name Brand Style Kind Name
     * @return BrandStyleKind
     */
    BrandStyle findByName(@Param("name") String name);

    /**
     * fetch data by name according to fuzzy query
     *
     * @param  name Brand Style Kind Name
     * @return Collection<BrandStyle>
     */
    Collection<BrandStyle> findByNameLike(@Param("name") String name);

    /** 复杂条件查询未实现
     @Query(" MATCH p=(s:Packcode)-[rp:Pc_LINK_Pc*0..]->(subP:Packcode)" +
     "WHERE subP.packcodeNo = {packcodeNo} and all( x in rp where x.bindStatus= {bindStatus}  )" +
     "RETURN  p")
     List<ProductStyleKind> find(@Param("name") String name);

     */

}

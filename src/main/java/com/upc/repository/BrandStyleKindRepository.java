package com.upc.repository;

import com.upc.domain.node.BrandStyleKind;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @Author: Pan
 * @Date: 2019/4/2 9:51
 * @Description:
 **/

@Repository
public interface BrandStyleKindRepository extends Neo4jRepository<BrandStyleKind,Long> {

    /**
     * fetch BrandStyleKind data by name
     *
     * @param  name Brand Style Kind Name
     * @return BrandStyleKind
     */
    BrandStyleKind findByName(@Param("name") String name);

    /**
     * fetch BrandStyleKind data by name fuzzy query
     *
     * @param name Brand Style Kind Name
     * @return Collection<BrandStyleKind>
     */
    Collection<BrandStyleKind> findByNameLike(@Param("name") String name);

/*   @Query("match(a:Brand_Style_Kind)-[re]->(b:Company)-[re2]->(c:Phone) return a,b,c")
    //@Query("match(a:Brand_Style_Kind) return a")
    List<BrandStyleKind> findAllByThree();*/

}

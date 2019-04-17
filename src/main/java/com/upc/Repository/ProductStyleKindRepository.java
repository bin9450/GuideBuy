package com.upc.Repository;

import com.upc.Domain.Node.ProductStyleKind;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @Author: Pan
 * @Date: 2019/4/2 16:54
 * @Description:
 **/

@Repository
public interface ProductStyleKindRepository extends Neo4jRepository<ProductStyleKind,Long> {

    ProductStyleKind findByName(@Param("name") String name);
    Collection<ProductStyleKind> findByNameLike(@Param("name") String name);

/*
    //关系复杂查询，为实现
    @Query("match(a:Brand_Style_Kind)-[re]->(b:Company)-[re2]->(c:Phone) return a,b,c")
    List<ProductStyleKind> findAllByThree();
*/

}

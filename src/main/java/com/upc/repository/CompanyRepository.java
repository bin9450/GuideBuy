package com.upc.repository;

import com.upc.domain.node.Company;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/1 20:01
 * @Description:
 **/

@Repository
public interface CompanyRepository extends Neo4jRepository<Company,Long>{

    /**
     * fetch BrandStyleKind data by name
     *
     * @param  shopName Company Name
     * @return Company
     */
    Company findByShopName(@Param("shop_name") String shopName);

    /**
     * fetch BrandStyleKind data by name fuzzy query
     *
     * @param  shopName Company Name
     * @return  Collection<Company>
     */
    Collection<Company> findByShopNameLike(@Param("shop_name") String shopName);

    /**
     * fetch Company data by Brand Style Kind Name
     *
     * @param  name Brand Style Kind Name
     * @return  Collection<Company>
     */
    @Query("match (a:Brand_Style_Kind)-[:Contain]->(b:Company)-[:SELLING_WITH]->(c:Phone)" +
            " where a.name = {name} " +
            "optional match p=(b:Company)-[s:SELLING_WITH]->(c:Phone) " +
            "return p")
    List<Company> findByBrand(@Param("name") String name);



}

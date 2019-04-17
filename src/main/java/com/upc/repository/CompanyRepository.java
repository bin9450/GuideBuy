package com.upc.repository;

import com.upc.domain.node.Company;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @Author: Pan
 * @Date: 2019/4/1 20:01
 * @Description:
 **/

@Repository
public interface CompanyRepository extends Neo4jRepository<Company,Long>{

    Company findByShopName(@Param("shop_name") String shopName);
    Collection<Company> findByShopNameLike(@Param("shop_name") String shopName);
}

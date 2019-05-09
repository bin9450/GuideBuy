package com.upc.repository;

import com.upc.domain.node.BrandStyleKind;
import com.upc.domain.node.Company;
import com.upc.domain.node.PhoneNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/5/6 11:14
 * @Description:
 **/

@Repository
public interface RecommendRepository extends Neo4jRepository {

    /**
     *  Lock company which is the most recommended
     *  according to user browsing, collection, adding shopping cart, purchase situation
     * @param userId user id
     * @return  Company
     */
    @Query("match (u:UserNode)-[:BROWSE_GOOD]->(p1:Phone)" +
            "<-[:SELLING_WITH]-(c1:Company)" +
            " where u.user_id={userId} with c1 \n" +
            "match (u:UserNode)-[:COLLECT_GOOD]->(p1:Phone)" +
            "<-[:SELLING_WITH]-(c2:Company)" +
            " where u.user_id={userId} and c2 = c1 with c2\n" +
            "match (u:UserNode)-[:CAR_GOOD]->(p1:Phone)" +
            "<-[:SELLING_WITH]-(c3:Company)" +
            " \twhere u.user_id={userId} and c3 = c2 with c3\n" +
            "match (u:UserNode)-[:BUY_GOOD]->(p1:Phone)" +
            "<-[:SELLING_WITH]-(c4:Company)\t" +
            " where u.user_id={userId} and c4 = c3 " +
            "return distinct c4")
    List<Company> getUnionCompany(@Param("userId") int userId);

    /**
     *  Lock company which is the second recommended
     *  according to user browsing, collection situation
     * @param userId user id
     * @return  Company
     */
    @Query("match (u:UserNode)-[:BROWSE_GOOD]->(p1:Phone)" +
            "<-[:SELLING_WITH]-(c1:Company) " +
            "where u.user_id={userId} with c1 \n" +
            "match (u:UserNode)-[:COLLECT_GOOD]->(p1:Phone)" +
            "<-[:SELLING_WITH]-(c2:Company) " +
            "where u.user_id={userId} and c2 = c1 \n" +
            "return distinct c2")
    List<Company> getSecCompany(@Param("userId") int userId);

    /**
     * Lock the user's favorite style by recommending the company's style
     * @param userId user id
     * @return  BrandStyleKind
     */
    @Query("match (u:UserNode)-[:BROWSE_GOOD]->(p1:Phone)" +
            "<-[:SELLING_WITH]-(c1:Company)" +
            " where u.user_id={userId} with c1 \n" +
            "match (u:UserNode)-[:COLLECT_GOOD]->(p1:Phone)" +
            "<-[:SELLING_WITH]-(c2:Company)" +
            " where u.user_id={userId} and c2 = c1 with c2\n" +
            "match (u:UserNode)-[:CAR_GOOD]->(p1:Phone)" +
            "<-[:SELLING_WITH]-(c3:Company) \t" +
            "where u.user_id={userId} and c3 = c2 with c3\n" +
            "match (u:UserNode)-[:BUY_GOOD]->(p1:Phone)" +
            "<-[:SELLING_WITH]-(c4:Company)\t " +
            "where u.user_id={userId} and c4 = c3 with c4\n" +
            "match (b1:Brand_Style_Kind)-[:Contain]->(c5:Company) " +
            "where c5 = c4 " +
            "return distinct b1")
    List<BrandStyleKind> getUnionBrandStyle(@Param("userId") int userId);

    /**
     * Lock the user's favorite style by the recommending company's style
     * @param shopName company name
     * @return  Company
     */
    @Query("match(b1:Brand_Style_Kind)-[:Contain]->(c:Company) " +
            "where c.shop_name = {shopName} with b1\n" +
            "match (b1)-[:Contain]->(c1:Company)  " +
            "return c1")
    List<Company> getOtherCompaniesOfTheSameType(@Param("shopName") String shopName);

    /**
     *calculate the average number of views for users
     * @param userId user id
     * @return  the average number
     */
    @Query("match (u:UserNode)-[b:BROWSE_GOOD]->(:Phone) \n" +
            "where u.user_id = {userId}\n" +
            "return avg b.BrowseTimes")
    int avgBrowseTimes(@Param("userId") int userId);

    /**
     * Calculate the average number of views for a company’s products
     * @param userId user id
     * @return  the average number
     */
    @Query("match (u:UserNode)-[b:BROWSE_GOOD]->(:Phone)" +
            "<-[:SELLING_WITH] -(c:Company)\n" +
            "where u.user_id = {userId} and c.shop_name = {company}\n" +
            "return avg(b.BrowseTimes)")
    int avgBrowseTimesCom(@Param("userId") int userId,
                          @Param("company") String company);

    /**
     * fetch items larger than the average number of views
     * @param userId user id
     * @param company company name
     * @param browseTimes  browseTimes
     * @return  PhoneNode
     */
    @Query("match (u:UserNode)-[b:BROWSE_GOOD]->(p:Phone)" +
            "<-[:SELLING_WITH] -(c:Company)\n" +
            "where u.user_id = {userId} and c.shop_name = {company} and b.BrowseTimes > {browseTimes} \n" +
            "return p")
    List<PhoneNode> moreBrowsePhone(@Param("userId") int userId,
                                    @Param("company") String company,
                                    @Param("browseTimes") int browseTimes);

    /**
     * fetch products that users have browsed
     * @param company company name
     * @return  PhoneNode
     */
    @Query("match (:UserNode)-[:BROWSE_GOOD]->(p:Phone)" +
            "<-[:SELLING_WITH] -(c:Company)\n" +
            "where c.shop_name = {company} \n" +
            "return p")
    List<PhoneNode> browsePhone(@Param("company") String company);

    /**
     * Calculate the average number of purchases for this user
     * @param userId user id
     * @return  PhoneNode
     */
    @Query("match (u:UserNode)-[b:BUY_GOOD]->(:Phone) \n" +
            "where u.user_id = {userId}  \n" +
            "return avg(b.BuyTimes)")
    int avgBuyTimes(@Param("userId") int userId);

    /**
     * Calculate the average number of purchases for this company’s products
     * @param userId user id
     * @return  PhoneNode
     */
    @Query("match (u:UserNode)-[b:BUY_GOOD]->(:Phone)" +
            "<-[:SELLING_WITH] -(c:Company)\n" +
            "where u.user_id = {userId} and c.shop_name = {company}\n" +
            "return avg(b.BuyTimes)")
    int avgBuyTimesCom(@Param("userId") int userId,
                       @Param("company") String company);


}

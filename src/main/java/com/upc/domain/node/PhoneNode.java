package com.upc.domain.node;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.springframework.data.annotation.Id;
import javax.persistence.GeneratedValue;

/**
 * @Author: Pan
 * @Date: 2019/4/1 19:38
 * @Description:
 **/

@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "Phone")
public class PhoneNode {
    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "good_id")
    private int goodId;
    @Property(name = "good_name")
    private String goodName;
    @Property(name = "shop_name")
    private String shopName;
    @Property(name = "price")
    private String price;
    @Property(name = "comment")
    private String comment;
    @Property(name = "good_pic")
    private String goodPic;


    public PhoneNode(int goodId, String goodName, String shopName, String price, String comment,String goodPic) {
        this.goodId = goodId;
        this.goodName = goodName;
        this.shopName = shopName;
        this.price = price;
        this.comment = comment;
        this.goodPic = goodPic;
    }

}

package com.upc.domain.node;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/1 19:42
 * @Description:
 **/

@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "Company")
public class Company {
    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "shop_name")
    private String shopName;

    @Property(name = "shop_pic")
    private String shopPic;

    public Company(String shopName,String shopPic) {
        this.shopName = shopName;
        this.shopPic = shopPic;
    }

   // @JsonIgnoreProperties(ignoreUnknown = true)
    @Relationship(type = "SELLING_WITH",direction = Relationship.OUTGOING)
    private List<PhoneNode> phoneNodes;
    public void addSellPhone(PhoneNode phoneNode){
        if(this.phoneNodes == null){
            this.phoneNodes = new ArrayList<>();
        }
        this.phoneNodes.add(phoneNode);
    }


}

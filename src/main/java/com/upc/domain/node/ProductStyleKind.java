package com.upc.domain.node;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

/**
 * @Author: Pan
 * @Date: 2019/4/2 16:47
 * @Description:
 **/

@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "Product_Style_Kind")
public class ProductStyleKind {

    @Id
    @GeneratedValue
    private  Long id;

    @Property(name = "name")
    private String name;

    public ProductStyleKind(String name){
        this.name = name;
    }

 /** (Product_Style_Kind)-[]->(PhoneNode)   关系未添加
    @Relationship(type = " ",direction = Relationship.OUTGOING)
    private List<PhoneNode> phoneNodes;
    public void add(PhoneNode phoneNode){
        if(this.phoneNodes == null){
            this.phoneNodes = new ArrayList<>();
        }
        this.phoneNodes.add(phoneNode);
    }
  */

}

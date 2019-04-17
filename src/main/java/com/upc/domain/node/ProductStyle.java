package com.upc.domain.node;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/3 17:08
 * @Description:
 **/

@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "Product_Style")
public class ProductStyle {

    @Id
    @GeneratedValue
    private  Long id;

    @Property(name = "name")
    private String name;

    public ProductStyle(String name){
        this.name = name;
    }

    @Relationship(type = "Contain",direction = Relationship.OUTGOING)
    private List<ProductStyleKind> productStyleKinds;
    public void addProductStyleKind(ProductStyleKind productStyleKind){
        if(this.productStyleKinds == null){
            this.productStyleKinds = new ArrayList<>();
        }
        this.productStyleKinds.add(productStyleKind);
    }


}

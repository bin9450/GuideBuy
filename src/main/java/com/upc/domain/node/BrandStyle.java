package com.upc.domain.node;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/3 17:09
 * @Description:
 **/

@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "Brand_Style")
public class BrandStyle {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "name")
    private String name;

    public BrandStyle (String name){
        this.name = name;
    }

    @Relationship(type = "Contain",direction = Relationship.OUTGOING)
    private List<BrandStyleKind> brandStyleKinds;
    public void addBrandStyleKind(BrandStyleKind brandStyleKind){
        if(this.brandStyleKinds == null){
            this.brandStyleKinds = new ArrayList<>();
        }
        this.brandStyleKinds.add(brandStyleKind);
    }
}

package com.upc.domain.node;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/2 9:44
 * @Description:
 **/

@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "Brand_Style_Kind")
public class BrandStyleKind {
    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "name")
    private String name;

    public BrandStyleKind(String name) {
        this.name = name;
    }

    //@JsonIgnoreProperties(ignoreUnknown = true)
    @Relationship(type = "Contain",direction = Relationship.OUTGOING)
    private List<Company> companies;
    public void addCompany(Company company){
        if(this.companies == null){
            this.companies = new ArrayList<>();
        }
        this.companies.add(company);

    }


}

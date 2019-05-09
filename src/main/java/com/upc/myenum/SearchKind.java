package com.upc.myenum;

import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * @Author: Pan
 * @Date: 2019/4/29 15:57
 * @Description:
 **/

@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
@Getter
@NoArgsConstructor
public enum SearchKind {

    ORG("Company","ORG"),
    m("No","m"),
    nz("Name","nz");

    private String name;
    private String kind;

    SearchKind(String name, String kind) {
        this.name = name;
        this.kind = kind;
    }

}

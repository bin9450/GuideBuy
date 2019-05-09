package com.upc.myenum;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: Pan
 * @Date: 2019/5/9 8:57
 * @Description:
 **/

@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
@Getter
@NoArgsConstructor
public enum OperationKind {

    BROWSE_GOOD(1,"BROWSE_GOOD","BrowseTimes"),
    COLLECT_GOOD(2,"COLLECT_GOOD"),
    CAR_GOOD(3,"CAR_GOOD"),
    BUY_GOOD(4,"BUY_GOOD","BuyTimes");

    private int key;
    private String value;
    private String parameter;

    OperationKind (int key,String value){
        this.key = key;
        this.value = value;
    }
    OperationKind (int key,String value,String parameter){
        this.key = key;
        this.value = value;
        this.parameter = parameter;
    }
}

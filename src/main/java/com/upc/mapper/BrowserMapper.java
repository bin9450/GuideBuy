package com.upc.mapper;


import com.upc.entity.Browser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/15 10:09
 * @Description:
 **/

@Repository
public interface BrowserMapper {
    List<Browser> selInfo(String userId );
    void insert(Browser browser);
}

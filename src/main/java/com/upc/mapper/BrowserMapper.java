package com.upc.mapper;


import com.upc.entity.Browser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/15 10:09
 * @Description:
 **/

@Repository
public interface BrowserMapper {
    List<Browser> selInfo(@Param("userId") String userId ,@Param("start") int start, @Param("end") int end);
    void insert(Browser browser);
}

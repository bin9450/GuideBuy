package com.upc.Mapper;

import com.upc.Entity.Phone;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: Pan
 * @Date: 2019/3/30 17:36
 * @Description:
 **/

@Repository
public interface PhoneMapper {
    Phone Sel(int id);
}

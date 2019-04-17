package com.upc.mapper;

import com.upc.entity.Phone;
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

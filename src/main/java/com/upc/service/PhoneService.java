package com.upc.service;

import com.upc.entity.Phone;
import com.upc.mapper.PhoneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Pan
 * @Date: 2019/3/30 17:37
 * @Description:
 **/

@Service
@Transactional
public class PhoneService {
    @Autowired
    PhoneMapper phoneMapper;
    public Phone Sel(int id){
        return phoneMapper.Sel(id)  ;
    }
}

package com.upc.service;

import com.upc.mapper.BuyOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Pan
 * @Date: 2019/4/18 19:00
 * @Description:
 **/

@Service
public class BuyOrderService {

    @Autowired
    BuyOrderMapper buyOrderMapper;
    
}

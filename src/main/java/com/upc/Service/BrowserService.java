package com.upc.Service;

import com.upc.Entity.Browser;
import com.upc.Mapper.BrowserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/15 10:19
 * @Description:
 **/

@Service
public class BrowserService {

    @Autowired
    BrowserMapper browserMapper;

    public List<Browser> selInfo(String userId ){
        return browserMapper.selInfo(userId);
    }
    public void insert(Browser browser){
        browserMapper.insert(browser);
    }

}

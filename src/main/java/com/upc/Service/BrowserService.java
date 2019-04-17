package com.upc.Service;

import com.upc.Domain.Relations.BrowserRelation;
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
    @Autowired
    BrowserRelationService browserRelationService;

    public List<Browser> selInfo(String userId ){
        return browserMapper.selInfo(userId);
    }
    public void insert(Browser browser){
        int userId = Integer.parseInt(browser.getUserId());
        int goodId = Integer.parseInt(browser.getGoodId());
        String lastTime = String.valueOf(browser.getBrowserTime());
        browserMapper.insert(browser);
        BrowserRelation result = browserRelationService.findByUserAndPhone(userId,goodId);
        if (result == null){
            browserRelationService.createBrowserRelation(userId,goodId,lastTime);
        }else {
            browserRelationService.updateInfo(userId,goodId,lastTime);
        }

    }

}

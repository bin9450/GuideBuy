package com.upc.service;

import com.upc.domain.relations.BrowserRelation;
import com.upc.entity.Browser;
import com.upc.mapper.BrowserMapper;
import com.upc.repository.PhoneNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    PhoneNodeRepository phoneNodeRepository;

    public List<Browser> selInfo(String userId ,int page){
        int size = 10;
        int start = (page-1)*size;
        int end = size;
        return browserMapper.selInfo(userId,start,end);
    }

    public void insert(Browser browser){
        int userId = Integer.parseInt(browser.getUserId());
        int goodId = Integer.parseInt(browser.getGoodId());
        Date date = new Date();
        browser.setBrowserTime(date);
        browserMapper.insert(browser);

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String lastTime = sdf.format(date);
        BrowserRelation result = browserRelationService.findByUserAndPhone(userId,goodId);
        if (result == null){
            browserRelationService.createBrowserRelation(userId,goodId,lastTime);
        }else {
            browserRelationService.updateInfo(userId,goodId,lastTime);
        }

        int comment = 5;
        phoneNodeRepository.setComment(goodId,comment);
    }

}

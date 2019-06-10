package com.upc.service;

import com.upc.config.MySort;
import com.upc.domain.node.PhoneNode;
import com.upc.repository.PhoneNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @Author: Pan
 * @Date: 2019/4/29 9:41
 * @Description:
 **/

@Service
public class SearchService {

    @Autowired
    MySort mySort;
    @Autowired
    AipNlpService aipNlpService;
    @Autowired
    PhoneNodeRepository phoneNodeRepository;

    public void setHotSearch (String search){
        HashMap<String,String> hashMap = aipNlpService.get(search);
        String sg = "";
      //  hashMap.get("Company")+hashMap.get("Name")+hashMap.get("No");
        for (String key : hashMap.keySet()){
            String value = hashMap.get(key);
            if (value != null){
                sg += value;
            }
        }
        //System.out.println("我要搜索的内容"+sg);
        mySort.sort(search);
    }

    public List<HashMap<String,String>> getHotSearch(){
        Set<Object> zset = mySort.findZset(0,10);
        List<HashMap<String,String>> list = new ArrayList<>();
        for (Object o:zset){
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("content",o.toString());
            list.add(hashMap);
       }
        return  list;
    }

    public List<PhoneNode> findByNameLike(String name , int page){
        int size = 6;
        int skip = (page-1)*size;
        int limit = size;
        String likeName = ".*(?i)"+name+".*";
        List<PhoneNode> result = phoneNodeRepository.findByNameLike(likeName,skip,limit);

        return result;
    }

}

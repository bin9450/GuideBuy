package com.upc.service;

import com.upc.config.AipNlpConfig;
import com.upc.entity.SearchKind;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Author: Pan
 * @Date: 2019/4/30 9:06
 * @Description:
 **/

@Service
public class AipNlpService {

    AipNlpConfig aipNlpConfig = new AipNlpConfig();

    public HashMap<String,String> get(String text){
        JSONObject result = aipNlpConfig.getResult(text);
        JSONArray jsonArray  = result.getJSONArray("items");
        HashMap<String,String> hashMap = new HashMap<>();
        for (int i=0;i<jsonArray.length();i++) {
            JSONObject job = jsonArray.getJSONObject(i);
            String value = job.getString("ne");
            String value1 = job.getString("pos");
            if (value1.equals("m"))
                continue;
            if (value.equals(SearchKind.ORG.getKind())||
                    value1.equals(SearchKind.ORG.getKind())){
                hashMap.put(SearchKind.ORG.getName(),job.getString("item"));
            }else if (value.equals(SearchKind.nz.getKind())||
                    value1.equals(SearchKind.nz.getKind())){
                hashMap.put(SearchKind.nz.getName(),job.getString("item"));
            }else if ( value.equals(SearchKind.m.getKind())||
                    value1.equals(SearchKind.m.getKind()) ){
                hashMap.put(SearchKind.m.getName(),job.getString("item"));
            }
        }

        return hashMap;
    }

}

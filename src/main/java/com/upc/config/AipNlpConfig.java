package com.upc.config;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;

/**
 * @Author: Pan
 * @Date: 2019/4/26 11:08
 * @Description:
 **/

public class AipNlpConfig {

    private  final String APP_ID = "16115530";
    private  final String API_KEY = "tHkgPjRRlVI2R1LaD26btryh";
    private  final String SECRET_KEY = "PjpksTZar7IA3TjAH1Q3lkwDlZb64QoB";

    public JSONObject getResult(String text) {
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
        // 调用接口
       // String text = "华为手机mate20pro";
        JSONObject res = client.lexer(text);
        //System.out.println(res.toString(2));
       return res;
    }

}

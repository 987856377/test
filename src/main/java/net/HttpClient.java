package net;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: test
 * @package net
 * @description
 * @author: XuZhenkui
 * @create: 2020-11-12 17:14
 **/
public class HttpClient {
    public static void main(String[] args) {
        String url = "https://zbsybj.darewayhealth.com/onlineDirectoryManage/queryBasicInfo";

        // x-www-form-urlencoded
        String str = "param={\"encodeRules\":\"HHUbg6SIPNUeTtNjuNazX6JynGSmJm828tvpeaaSY3/TFpGcsQtDMcwWh+0vtLeakzZxV2BKTlgqqCGVUtf1YIgzixE7kmqW79O+eu6zmGpRqK/iZXAZz6oNC7F6Qu6ZZFDuh+qh2S/yNZJ4pRiwY9gMMPPeqhl5lkPSU6z4cYU=\",\"sign\":\"T4FJ6WK9k2jIQreJpMFU7xVrWcH8WO2ai6plxKwY4idTnBbBLY8+CR70YSk6HS8EQ6OkOoht9mmRrd/2FbRLc0285nwP55T3qe0hlYboFXVAWSEbu92yr3zZYfZE9cFDZJqDhmqrLzIn5DBtKpkvlopX0mYhGcwe8GOjLYokFKA=\",\"content\":\"d2tBGuLcUJszwzQKfaRLeOrBJA/c4sTgNjMnJsaTQHfyYhdQdJ2B1+Q5xtheqsFvYzDL1RaBd6FNGc4D8YveLGFmdD5zAdh7cV98GAqDALxBn/9Scmd8o5jdb//W7jAP\",\"yybh\":\"330004\",\"timestamp\":1605170946626}";
        String post = HttpUtil.post(url, str);
        System.out.println("post = " + post);

        // x-www-form-urlencoded
        String encode = "{\"encodeRules\":\"izD7gvwvBi+ITdssjEF2+gM1yc7tPJ0W/Mtya92bE8G9GiLpyImntF8xeAdWYGnY05gbNucZaQe5qsps8c2wSOdzq+BMEUyQJ76biKJi/IRXhu8nmfnip0DryHwpwNdU0aVQrvj07VxWuV5pjWTJ+mT92sP4qdJf3XVV5tSOl7E=\",\"sign\":\"PUhhxahPisqNEfGZ1widPHIciW8c2dBgRxCizj03DkTzMUnCzQ6/9B9B60jA0fUqHHPT+Ov2Rk/2RqUMf1M4IzlR6ykm1nEsu8Etg6JlDFSqPH7l6xWJFIWp5mjwOSUpWVFgBN401nV9pzPiHePvuJTRm1AHgFyNLJd4TCfqJaY=\",\"content\":\"eEbptmAvcrwnkN7ksWOLTS6cOlXteExtOCGvfoKeiOwercEgpVnC+5CJXtNKHR2v6YQzIuRZjzevYRFZX12u0J7rDKEbroSponixdNJCsbdjgBRcMliTVJvwPocmRLca\",\"timestamp\":1605171261429}";
        JSONObject jo = JSON.parseObject(encode);
        jo.put("yybh", "330004");
        Map<String, Object> map = new HashMap<>();
        map.put("param", jo.toString());
        String result = HttpUtil.post(url, map, 30000);
        System.out.println(result);

        // json
        String local = "127.0.0.1:8080/basic";
        String body = "{\"ds\":\"dsd\"}";
        String post1 = HttpUtil.post(local, body);
        System.out.println(post1);
    }
}

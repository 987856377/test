package base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tencent.healthcard.exception.FuncRetCode;
import com.tencent.healthcard.exception.ServerException;
import com.tencent.healthcard.util.HttpUtil;

public abstract class AbstractService implements Service {

    protected JSONObject request(String url, String jsonParam, int connectTimeout, int readTimeout) {
        String result = HttpUtil.post(url, jsonParam, connectTimeout, readTimeout);
        if (result == null) {
            throw new ServerException(FuncRetCode.ERROR_CODE_NET_ERROR);
        } else {
            JSONObject jsonObject = JSON.parseObject(result);
            return jsonObject;
        }
    }
}

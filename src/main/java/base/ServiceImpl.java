package base;

import com.alibaba.fastjson.JSONObject;
import com.tencent.healthcard.HealthCardServer;
import com.tencent.healthcard.model.CommonIn;
import com.tencent.healthcard.model.HealthCardInfo;
import com.tencent.healthcard.model.ReportHISData;
import com.tencent.healthcard.model.VerifyQRCodeInfo;
import com.tencent.healthcard.util.CommonUtil;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ServiceImpl extends AbstractService{
    private String secret;
    private int connectTimeout = 10;
    private int readTimeout = 10;

    @Override
    public JSONObject getAppToken(CommonIn commonIn, String appId) {
        return this.getAppToken(commonIn, appId, this.connectTimeout, this.readTimeout);
    }

    public JSONObject getAppToken(CommonIn commonIn, String appId, int connectTimeout, int readTimeout) {
        Map<String, Object> param = new TreeMap();
        param.put("appId", appId);
        String reqJson = CommonUtil.packParam(this.secret, commonIn, param);
        return this.request(HealthCardServer.URL.GET_ACCESS_TOKEN, reqJson, connectTimeout * 1000, readTimeout * 1000);
    }

    @Override
    public JSONObject registerHealthCard(CommonIn var1, HealthCardInfo var2) {
        return null;
    }

    @Override
    public JSONObject getHealthCardByHealthCode(CommonIn var1, String var2) {
        return null;
    }

    @Override
    public JSONObject getHealthCardByQRCode(CommonIn var1, String var2) {
        return null;
    }

    @Override
    public JSONObject ocrInfo(CommonIn var1, String var2) {
        return null;
    }

    @Override
    public JSONObject bindCardRelation(CommonIn var1, String var2, String var3) {
        return null;
    }

    @Override
    public JSONObject reportHISData(CommonIn var1, ReportHISData var2) {
        return null;
    }

    @Override
    public JSONObject getOrderIdByOutAppId(CommonIn var1, String var2, String var3) {
        return null;
    }

    @Override
    public JSONObject registerBatchHealthCard(CommonIn var1, List<HealthCardInfo> var2) {
        return null;
    }

    @Override
    public JSONObject getDynamicQRCode(CommonIn var1, String var2, String var3, String var4, String var5) {
        return null;
    }

    @Override
    public JSONObject verifyQRCode(CommonIn var1, VerifyQRCodeInfo var2) {
        return null;
    }

    @Override
    public JSONObject registerOrder(CommonIn var1, String var2, String var3) {
        return null;
    }

    @Override
    public JSONObject verifyFaceIdentity(CommonIn var1, String var2, String var3) {
        return null;
    }

    @Override
    public JSONObject updateHealthCardId(CommonIn var1, List<HealthCardInfo> var2) {
        return null;
    }
}

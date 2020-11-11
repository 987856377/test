package base;

import com.alibaba.fastjson.JSONObject;
import com.tencent.healthcard.model.CommonIn;
import com.tencent.healthcard.model.HealthCardInfo;
import com.tencent.healthcard.model.ReportHISData;
import com.tencent.healthcard.model.VerifyQRCodeInfo;

import java.util.List;

public interface Service {
    JSONObject getAppToken(CommonIn var1, String var2);

    JSONObject registerHealthCard(CommonIn var1, HealthCardInfo var2);

    JSONObject getHealthCardByHealthCode(CommonIn var1, String var2);

    JSONObject getHealthCardByQRCode(CommonIn var1, String var2);

    JSONObject ocrInfo(CommonIn var1, String var2);

    JSONObject bindCardRelation(CommonIn var1, String var2, String var3);

    JSONObject reportHISData(CommonIn var1, ReportHISData var2);

    JSONObject getOrderIdByOutAppId(CommonIn var1, String var2, String var3);

    JSONObject registerBatchHealthCard(CommonIn var1, List<HealthCardInfo> var2);

    JSONObject getDynamicQRCode(CommonIn var1, String var2, String var3, String var4, String var5);

    JSONObject verifyQRCode(CommonIn var1, VerifyQRCodeInfo var2);

    JSONObject registerOrder(CommonIn var1, String var2, String var3);

    JSONObject verifyFaceIdentity(CommonIn var1, String var2, String var3);

    JSONObject updateHealthCardId(CommonIn var1, List<HealthCardInfo> var2);

    public static class URL {
        public static String GET_ACCESS_TOKEN = "https://healthopen.healthcard.qq.com/rest/auth/HealthCard/HealthOpenAuth/AuthObj/getAppToken";
        public static String REGISTER_HEALTH_CARD = "https://healthopen.healthcard.qq.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/registerHealthCard";
        public static String GET_HEALTH_CARD_BY_HEALTH_CODE = "https://healthopen.healthcard.qq.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/getHealthCardByHealthCode";
        public static String GET_HEALTH_CARD_BY_QR_CODE = "https://healthopen.healthcard.qq.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/getHealthCardByQRCode";
        public static String OCR_INFO = "https://healthopen.healthcard.qq.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/ocrInfo";
        public static String BIND_CARD_RELATION = "https://healthopen.healthcard.qq.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/bindCardRelation";
        public static String REPORT_HISDATA = "https://healthopen.healthcard.qq.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/reportHISData";
        public static String GET_ORDER_ID_BY_OUT_APP_ID = "https://healthopen.healthcard.qq.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/getOrderIdByOutAppId";
        public static String REGISTER_BATCH_HEALTH_CARD = "https://healthopen.healthcard.qq.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/registerBatchHealthCard";
        public static String GET_DYNAMIC_QRCODE = "https://healthopen.healthcard.qq.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/getDynamicQRCode";
        public static String VERIFY_QRCODE = "https://healthopen.healthcard.qq.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/verifyQRCode";
        public static String REGISTER_ORDER = "https://healthopen.healthcard.qq.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/registerOrder";
        public static String VERIFY_FACE_IDENTITY = "https://healthopen.healthcard.qq.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/verifyFaceIdentity";
        public static String UPDATE_HEALTHCARD_ID = "https://healthopen.healthcard.qq.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/updateHealthCardId";
        public static String REGISTER_UNIFORM_ORDER = "https://healthopen.healthcard.qq.com/rest/auth/HealthCard/HealthOpenPlatform/ISVOpenObj/registerUniformOrder";

        public URL() {
        }

        public static void setGetAccessToken(String getAccessToken) {
            GET_ACCESS_TOKEN = getAccessToken;
        }

        public static void setRegisterHealthCard(String registerHealthCard) {
            REGISTER_HEALTH_CARD = registerHealthCard;
        }

        public static void setGetHealthCardByHealthCode(String getHealthCardByHealthCode) {
            GET_HEALTH_CARD_BY_HEALTH_CODE = getHealthCardByHealthCode;
        }

        public static void setGetHealthCardByQrCode(String getHealthCardByQrCode) {
            GET_HEALTH_CARD_BY_QR_CODE = getHealthCardByQrCode;
        }

        public static void setOcrInfo(String ocrInfo) {
            OCR_INFO = ocrInfo;
        }

        public static void setBindCardRelation(String bindCardRelation) {
            BIND_CARD_RELATION = bindCardRelation;
        }

        public static void setReportHisdata(String reportHisdata) {
            REPORT_HISDATA = reportHisdata;
        }

        public static void setGetOrderIdByOutAppId(String getOrderIdByOutAppId) {
            GET_ORDER_ID_BY_OUT_APP_ID = getOrderIdByOutAppId;
        }

        public static void setRegisterBatchHealthCard(String registerBatchHealthCard) {
            REGISTER_BATCH_HEALTH_CARD = registerBatchHealthCard;
        }

        public static void setGetDynamicQrcode(String getDynamicQrcode) {
            GET_DYNAMIC_QRCODE = getDynamicQrcode;
        }

        public static void setVerifyQrcode(String verifyQrcode) {
            VERIFY_QRCODE = verifyQrcode;
        }

        public static void setRegisterOrder(String registerOrder) {
            REGISTER_ORDER = registerOrder;
        }

        public static void setVerifyFaceIdentity(String verifyFaceIdentity) {
            VERIFY_FACE_IDENTITY = verifyFaceIdentity;
        }

        public static void setUpdateHealthcardId(String updateHealthcardId) {
            UPDATE_HEALTHCARD_ID = updateHealthcardId;
        }
    }
}

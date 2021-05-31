package tool.util;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.RSAEngine;
import org.bouncycastle.crypto.generators.RSAKeyPairGenerator;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.crypto.util.PrivateKeyFactory;
import org.bouncycastle.crypto.util.PrivateKeyInfoFactory;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.crypto.util.SubjectPublicKeyInfoFactory;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: test
 * @package tools.util
 * @description
 * @author: XuZhenkui
 * @create: 2020-12-30 15:59
 **/
public class RSAUtil {

    private static final AsymmetricBlockCipher cipher = new RSAEngine();
    private static final Base64.Encoder encoder = Base64.getEncoder();
    private static final Base64.Decoder decoder = Base64.getDecoder();

    public static Map<String, String> generateKeyPair() throws IOException {
        Map<String, String> map = new HashMap<>();
        //生成密钥对
        RSAKeyPairGenerator rsaKeyPairGenerator = new RSAKeyPairGenerator();
        RSAKeyGenerationParameters rsaKeyGenerationParameters = new RSAKeyGenerationParameters(BigInteger.valueOf(3), new SecureRandom(), 1024, 25);
        rsaKeyPairGenerator.init(rsaKeyGenerationParameters);//初始化参数
        AsymmetricCipherKeyPair keyPair = rsaKeyPairGenerator.generateKeyPair();

        AsymmetricKeyParameter publicKey = keyPair.getPublic();//公钥
        AsymmetricKeyParameter privateKey = keyPair.getPrivate();//私钥

        SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(publicKey);
        PrivateKeyInfo privateKeyInfo = PrivateKeyInfoFactory.createPrivateKeyInfo(privateKey);

        //变字符串
        ASN1Object asn1ObjectPublic = subjectPublicKeyInfo.toASN1Primitive();
        byte[] publicInfoByte = asn1ObjectPublic.getEncoded();
        ASN1Object asn1ObjectPrivate = privateKeyInfo.toASN1Primitive();
        byte[] privateInfoByte = asn1ObjectPrivate.getEncoded();

        //这里可以将密钥对保存到本地
        map.put("publicKey", encoder.encodeToString(publicInfoByte));
        map.put("privateKey", encoder.encodeToString(privateInfoByte));
        return map;
    }

    //加密
    public static String encrypt(String data, String publicKey) throws IOException, InvalidCipherTextException {
        //加密
        byte[] publicInfoBytes = decoder.decode(publicKey);

        ASN1Object pubKeyObj = ASN1Primitive.fromByteArray(publicInfoBytes); //这里也可以从流中读取，从本地导入
        AsymmetricKeyParameter pubKey = PublicKeyFactory.createKey(SubjectPublicKeyInfo.getInstance(pubKeyObj));

        cipher.init(true, pubKey);//true表示加密
        byte[] encryptDataBytes = cipher.processBlock(data.getBytes(StandardCharsets.UTF_8), 0, data.getBytes(StandardCharsets.UTF_8).length);
        return encoder.encodeToString(encryptDataBytes);
    }

    //解密
    public static String decrypt(String data, String privateKey) throws IOException, InvalidCipherTextException {
        byte[] encryptDataBytes = decoder.decode(data);

        //解密
        byte[] privateInfoByte = decoder.decode(privateKey);
        AsymmetricKeyParameter priKey = PrivateKeyFactory.createKey(privateInfoByte);
        cipher.init(false, priKey);//false表示解密

        byte[] decryptDataBytes = cipher.processBlock(encryptDataBytes, 0, encryptDataBytes.length);
        return new String(decryptDataBytes, StandardCharsets.UTF_8);
    }
}

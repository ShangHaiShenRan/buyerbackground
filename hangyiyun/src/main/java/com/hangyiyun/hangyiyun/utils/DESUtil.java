package com.hangyiyun.hangyiyun.utils;

import org.bouncycastle.util.encoders.Hex;
//import org.spongycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.net.URLEncoder;
import java.security.Key;
import java.security.SecureRandom;


public class DESUtil {
    public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";



    /**
     * 加密数据 
     * @param data 待加密数据 
     * @param key 密钥 
     * @return 加密后的数据  
     */  
    /*public static String encrypt(String data, String key) throws Exception { 
        Key deskey = keyGenerator(key);*/  
    public static String encrypt(String data,String key) throws Exception {
        Key deskey = keyGenerator(key);
        // 实例化Cipher对象，它用于完成实际的加密操作  
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);  
        SecureRandom random = new SecureRandom();
            // 初始化Cipher对象，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, deskey, random);  
        byte[] results = cipher.doFinal(data.getBytes("utf-8"));  
        // 执行加密操作。加密后的结果通常都会用Base64编码进行传输   
        return Hex.toHexString(results);
    }


    /**  
     * 解密数据  
     * @param data 待解密数据  
     * @param key 密钥
     * @return 解密后的数据
     */  
    /*public static String decrypt(String data, String key) throws Exception { 
        Key deskey = keyGenerator(key);*/  
    public static String decrypt(String data,String key) throws Exception {
        Key deskey = null;
        deskey = keyGenerator(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        //初始化Cipher对象，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, deskey);
        // 执行解密操作
        return new String(cipher.doFinal(Hex.decode(data)));
    }
      
    /**
     *
     * 生成密钥key对象
     * @param keyStr 密钥字符串
     * @return 密钥对象
     * @throws Exception
     */
    private static SecretKey keyGenerator(String keyStr) throws Exception {
        //byte input[] = hexString2Bytes(keyStr);
        byte input[] = keyStr.getBytes();
        DESKeySpec desKey = new DESKeySpec(input);
        //创建一个密匙工厂，然后用它把DESKeySpec转换成SecretKey
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(desKey);
        return securekey;
    }
      

    public static void main(String[] args) {

        try {
//            System.out.println(encrypt("{\"companyName\":\"测试数据企业无九方la\",\"merchantType\":2,\"origin\":8,\"password\":\"Zlz13117500158\",\"phone\":\"17611118815\",\"platformCode\":\"COM26506\",\"registerType\":0,\"timestamp\":1587347976744,\"userCode\":\"COM3151811246\"}\n","ded3f805f7dcfcbd6a63b0d08ea669fb"));
//            System.out.println(decrypt(encrypt("{\"companyName\":\"测试数据企业无九方la\",\"merchantType\":2,\"origin\":8,\"password\":\"Zlz13117500158\",\"phone\":\"17611118815\",\"platformCode\":\"COM26506\",\"registerType\":0,\"timestamp\":1587347976744,\"userCode\":\"COM3151811246\"}\n","ded3f805f7dcfcbd6a63b0d08ea669fb"),"ded3f805f7dcfcbd6a63b0d08ea669fb"));
//            System.out.println(decrypt("b1e6a35b2f698d7fd3b8142813ec85ac021a4" +
//                    "1a35a22e6b7268c5c4c85023a00f0f072f5e5220e2d56f0452ffc9cf8671de806aa401aae90fa76" +
//                    "6149356f6307976c72d9b182806c72f47d9dd2d6f49c64095dc721ab2c83f2758a13080a9141ec567684dcb5d4d" +
//                    "9e29cc9d2775d1fa15c5d15057e4ca5e47c602c70e4723906940880cd1e8a0e070ddde7213791ae273b1194a32a435f86dfd" +
//                    "1cc828736666f1bdb5c6e000e375f21d57d78f834b2387af184ae459012ece5af2676cbe77b41a61901585756cceff136c" +
//                    "0a45e2a19863f26b5c4861579dfa42b6013e5df7d5c","COM5704601385"));

//            System.out.println(decrypt("abfd794a79bbf7dbb06da1a02533c6a7fbee9bd0715fd7831fe55feeec03b61" +
//                    "0ef0c655e1c838c4657e104d7bd5fb2fa","COM5704601385"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

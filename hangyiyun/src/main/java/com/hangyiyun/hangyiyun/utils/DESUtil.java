package com.hangyiyun.hangyiyun.utils;

import org.bouncycastle.util.encoders.Hex;
//import org.spongycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
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
            System.out.println(encrypt("15318828897","ded3f805f7dcfcbd6a63b0d08ea669fb"));
            System.out.println(encrypt("15318828897,"+System.currentTimeMillis(),"ded3f805f7dcfcbd6a63b0d08ea669fb"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

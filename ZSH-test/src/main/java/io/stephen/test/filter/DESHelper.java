package io.stephen.test.filter;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * @author 10447
 * @since 2018/4/16
 */
public class DESHelper {

    private static String key ;
    //算法名称
    public static final String KEY_ALGORITHM = "DES";
    //算法名称/加密模式/填充方式
    //DES共有四种工作模式-->>ECB：电子密码本模式、CBC：加密分组链接模式、CFB：加密反馈模式、OFB：输出反馈模式
    public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";

    /**
     * 生成密钥
     */
    static {
        KeyGenerator kg = null; //实例化密钥生成器
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        kg.init(56);                                               //初始化密钥生成器
        SecretKey secretKey = kg.generateKey();                    //生成密钥
        key = Base64.encodeBase64String(secretKey.getEncoded());  //获取二进制密钥编码形式
    }


    /**
     * 转换密钥
     */
    private static Key toKey(byte[] key) throws Exception {
        DESKeySpec dks = new DESKeySpec(key);                                      //实例化Des密钥
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM); //实例化密钥工厂
        SecretKey secretKey = keyFactory.generateSecret(dks);                      //生成密钥
        return secretKey;
    }

    /**
     * 加密数据
     * @param data 待加密数据
     * @param key  密钥
     * @return 加密后的数据
     */
    public static String encrypt(String data) throws Exception {
        Key k = toKey(Base64.decodeBase64(DESHelper.key));                           //还原密钥
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);              //实例化Cipher对象，它用于完成实际的加密操作
        cipher.init(Cipher.ENCRYPT_MODE, k);                               //初始化Cipher对象，设置为加密模式
        return Base64.encodeBase64String(cipher.doFinal(data.getBytes())); //执行加密操作。加密后的结果通常都会用Base64编码进行传输
    }

    /**
     * 解密数据
     * @param data 待解密数据
     * @param key  密钥
     * @return 解密后的数据
     */
    public static String decrypt(String data) throws Exception {
        Key k = toKey(Base64.decodeBase64(DESHelper.key));
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, k);                           //初始化Cipher对象，设置为解密模式
        return new String(cipher.doFinal(Base64.decodeBase64(data)));  //执行解密操作
    }

    public static void main(String[] args) throws Exception {
        String source = "岂向苍天";
        System.out.println("原文: " + source);


        System.out.println("密钥: " + key);

        String encryptData = encrypt(source);
        System.out.println("加密: " + encryptData);

        String decryptData = decrypt(encryptData);
        System.out.println("解密: " + decryptData);
    }

}

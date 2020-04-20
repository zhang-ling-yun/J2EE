package cn.edu.scut.ssm.util;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;

/**
 * @author: rain
 * @date: 2019-4-19 09:41
 * @description: ssm
 */
public class DESUtil {
    private static Key key;

    /**
     * 设置密钥key
     */
    private static String KEY_STR = "s2_I$-!#eu_3y2*4D-8^2{A3R_E}I5%&U#I@-O;!";
    private static String CHARSET = "UTF-8";
    private static String ALGORITHM = "DES";

    static {
        try {
            // 生成DES算法对象
            KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
            // 运行SHA1安全策略
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            // 设置上密钥种子
            secureRandom.setSeed(KEY_STR.getBytes());
            // 初始化基于SHA1的算法对象
            generator.init(secureRandom);
            // 生成密钥对象
            key = generator.generateKey();
            generator = null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取加密后的信息
     *
     * @param str 待加密字符串
     * @return
     */
    public static String getEncryptString(String str) {
        // 基于BASE64编码，接收byte[]并转换为String
        Encoder base64encoder = Base64.getEncoder();
        try {
            // 按UTF-8编码
            byte[] bytes = str.getBytes(CHARSET);
            // 获取加密对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            // 初始化密码信息
            cipher.init(Cipher.ENCRYPT_MODE, key);
            // 加密
            byte[] doFinal = cipher.doFinal(bytes);
            // byte[] to encode好的String并返回
            String result = base64encoder.encodeToString(doFinal);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取解密之后的信息
     *
     * @param str 待解密字符串
     * @return
     */
    public static String getDecryptString(String str) {
        // 基于BASE64编码，接收byte[]并转换为String
        Decoder base64decoder = Base64.getDecoder();
        try {
            // 将字符串decode成byte[]
            byte[] bytes = base64decoder.decode(str);
            // 获取解密对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            // 初始化解密信息
            cipher.init(Cipher.DECRYPT_MODE, key);
            // 解密
            byte[] doFinal = cipher.doFinal(bytes);
            // 返回解密之后的信息
            return new String(doFinal, CHARSET);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

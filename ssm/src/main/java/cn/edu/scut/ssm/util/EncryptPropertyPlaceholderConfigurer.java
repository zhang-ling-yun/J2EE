package cn.edu.scut.ssm.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @author: rain
 * @date: 2019-4-19 10:20
 * @description: ssm
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    /**
     * 需要加密的字段数组
     */
    private String[] encryptPropNames = { "druid.username", "druid.password" };

    /**
     * 对关键的属性进行转换
     */
    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        // 判断是否加密
        if (isEncryptProp(propertyName)) {
            // 解密
            String decryptValue = DESUtil.getDecryptString(propertyValue);
            return decryptValue;
        } else {
            return propertyValue;
        }
    }

    /**
     * 判断该属性是否加密
     *
     * @param propertyName
     * @return
     */
    private boolean isEncryptProp(String propertyName) {
        for (String encryptPropertyName : encryptPropNames) {
            if (encryptPropertyName.equals(propertyName)) {
                return true;
            }
        }
        return false;
    }
}

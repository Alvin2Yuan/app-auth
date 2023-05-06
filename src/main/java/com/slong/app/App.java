package com.slong.app;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.crypto.KeyUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.util.Arrays;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnsupportedEncodingException {
        //授权Mac地址 默认是所有Ip
        String mac="*";
        //授权时长
        String longTime="";
        //当前时间开始 按天授权 默认30天
        Date newDate = DateUtil.offset(new Date(), DateField.DAY_OF_MONTH, 30);
        //拼接授权Key
        String key="授权应用体验截止时间为==>>"+newDate.toString();
        String privateKey="q7M+XTfwAtNHfsjTS1f3tw==";
        //System.out.println(new String(SecureUtil.generateKey("SM4").getEncoded()));

        SymmetricCrypto sm4 = SmUtil.sm4(Base64.decode(privateKey));
       // System.out.println(Base64.encode(sm4.getSecretKey().getEncoded()));
        String encryptHex = sm4.encryptBase64(key);

        System.out.println(encryptHex);
        System.out.println(sm4.decryptStr(encryptHex));
    }
}

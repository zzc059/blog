package com.chenbo.utils;

/**
 * @author 11366
 * 这是一个md5加密的工具类
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	public static String getMD5(String string) {
		MessageDigest md5 = null;
		try {
			//通过MessageDigest的静态方法getInstance传入算法得到md5实例
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//把传入的String变成字符数组
		char[] charArray = string.toCharArray();
		byte[] byteArray = new byte[charArray.length];
		//再把字符数组转化陈Byte数组
		for (int i = 0; i < charArray.length; i++) {
			byteArray[i] = (byte) charArray[i];
		}
		//通过digest方法传入Byte数组得到md5之后的Byte数组
		byte[] md5Bytes = md5.digest(byteArray);

		StringBuffer HexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			//得到每个byte的16进制数
			int val = ((int) md5Bytes[i]) & 0xff;
			//如果小于16就给他补一个0
			if (val < 16) {
				HexValue.append("0");
			}
			//将得到的的int值转化成Hex在转成数组加入进StringBuffer
			HexValue.append(Integer.toHexString(val));
		}
		return HexValue.toString();

	}
}

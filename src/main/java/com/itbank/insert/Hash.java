package com.itbank.insert;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	
	public static String getHash(String userpw) { // 비밀번호 함수
		
		try {
			// Secure Hash Algorithm 512 : 입력값이 같으면 출력결과도 같으며, 출력결과는 다른값과 중복되지 않음을 보장하는 알고리즘
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.reset();
			md.update(userpw.getBytes("UTF-8"));
			String ret = String.format("%0128x", new BigInteger(1, md.digest()));
									// 128비트 16진수
			return ret;
			
		} catch (NoSuchAlgorithmException e) {
			System.out.println("알고리즘이 없습니다 : " + e);
//			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("그런 인코딩은 없습니다 : " + e);
//			e.printStackTrace();
		}
		
		return null;
	}
	
}

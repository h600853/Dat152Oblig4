/**
 * 
 */
package no.hvl.dat152.obl4.util;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import java.util.Base64;
import java.util.UUID;

import javax.xml.bind.DatatypeConverter;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.codec.digest.DigestUtils;

import static java.util.Base64.*;
import static org.apache.commons.codec.binary.Base64.encodeBase64URLSafeString;


public class Crypto {

	
	public static String generateUUIDCode() {
		return UUID.randomUUID().toString();
	}
	
	public static String generateSHA256(String value) {

		return DigestUtils.sha256Hex(value);
	}
	
	public static String generateSHA1Hash(String value) {
		
		return DigestUtils.md5Hex(value);
	}
	
	public static String generateRandomCryptoCode() {
		
		SecureRandom sr = null;
		try {
			sr = SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			//
		}
		byte[] ivsecret = new byte[16];
		sr.nextBytes(ivsecret);
		
		return DatatypeConverter.printHexBinary(ivsecret);
	}
	public static String generateCSRFtoken(HttpServletRequest request) {
		SecureRandom sr = new SecureRandom();
		byte[] csrf = new byte[16];
		sr.nextBytes(csrf);
		String token = encodeBase64URLSafeString(csrf);
		request.getSession().setAttribute("csrftoken", token);
		return token;
	}


}

package no.hvl.dat152.obl4.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Validator {

	public static boolean validPassword(String password) {
		// Password must be between 6 and 20 characters long and contain at least one digit,
		// one upper case letter, one lower case letter and no whitespace.
				String regex = "^(?=.*[0-9])"
				+ "(?=.*[a-z])(?=.*[A-Z])"
				+ "(?=\\S+$).{6,20}$";
		return password.matches(regex);
	}
	public static String validString(String parameter) {
		return parameter != null ? parameter : "null";
	}
	
	public static String getCookieValue(HttpServletRequest request,
			String cookieName) {

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(cookieName)) {
					return c.getValue();
				}
			}
		}
		return null;
	}
}

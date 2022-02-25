package utils;

import java.util.Random;

public class TestHelper {

	// This method generates a random 12 char gmail email address
	public static String generateRandomEmail() {
		return generateRandomString(12) + "@gmail.com";
	}

	public static String generateRandomString(int length) {
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		while (sb.length() < length+1) {
			int index = random.nextInt(base.length());
			sb.append(base.charAt(index));
		}
		return sb.toString();
	}
}

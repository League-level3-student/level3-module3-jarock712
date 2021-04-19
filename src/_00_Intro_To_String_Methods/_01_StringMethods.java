package _00_Intro_To_String_Methods;

import java.util.Base64;
public class _01_StringMethods {
	
    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
    	if (s1.length() > s2.length()) {
			return s1;
		}else {
			return s2;
		}
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
    	if (s.contains("underscores")) {
			s = s.replace(" ", "_");
		}
        return s;
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
    	int i = 0;
    	while(s1.charAt(i) == ' ') {
    		s1 = s1.substring(i + 1);
    	}
    	String s1new = s1.split(" ")[0];
    	String s1new2 = s1.split(" ")[1];
    	
    	i = 0;
    	while(s2.charAt(i) == ' ') {
    		s2 = s2.substring(i + 1);
    	}
    	String s2new = s2.split(" ")[0];
    	String s2new2 = s2.split(" ")[1];
    	
    	i = 0;
    	while(s3.charAt(i) == ' ') {
    		s3 = s3.substring(i + 1);
    	}
    	String s3new = s3.split(" ")[0];
    	String s3new2 = s3.split(" ")[1];
    	
    	if (s1new2.compareTo(s2new2) < 0 && s1new2.compareTo(s3new2) < 0) {
			return s1new + " " + s1new2;
		}
    	if(s2new2.compareTo(s1new2) < 0 && s2new2.compareTo(s3new2) < 0) {
    		return s2new + " " + s2new2;
    	}
        return s3new + " " + s3new2;
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
    	int num = 0;
    	for (int i = 0; i < s.length(); i++) {
			if ("0123456789".contains(s.substring(i, i + 1))) {
				num += Integer.parseInt(s.substring(i, i + 1));
			}
		}
        return num;
    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
    	int num = 0;
    	int fullList = s.indexOf(substring);
    	while (fullList != -1) {
			num++;
			fullList = s.indexOf(substring, fullList + substring.length());
		}
        return num;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
        return Utilities.encrypt(s.getBytes(), (byte) key);
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
        return Utilities.decrypt(s, (byte) key);
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
    	String[] list =s.split(" ");
    	int num = 0;
    	for (int i = 0; i < list.length; i++) {
			if (list[i].length() < substring.length()){
			}else if(list[i].substring(list[i].length() - substring.length()).equals(substring)) {
				num++;
			}
		}
        return num;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
    	int indexNew = s.indexOf(substring);
    	int indexNew2 = s.lastIndexOf(substring);
        return indexNew2 - substring.length() - indexNew;
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
    	for (int i = 0; i < s.length(); i++) {
			if ("madam".contains(s.charAt(i) + "")) {
				s = s.substring(0, i) + s.substring(i + 1);
			}
		}
    	
    	s = s.replace(" ", "");
    	String s1 = s.substring(0, (s.length() + 1) / 2);
    	s1 = s1.toLowerCase();
    	char[] s3 = s1.toCharArray();
    	String s2 = s.substring(s.length() / 2);
    	s2 = s2.toLowerCase();
    	char[] s4 = s2.toCharArray();
    	
    	int hold = 1;
    	for (int i = 0; i < s3.length; i++) {
			if (s4[s4.length - hold] == ' ') {
				hold++;
				i--;
			}else if(s3[i] != s4[s4.length - i - hold]) {
				return false;
			}
		}
        return true;
    }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}

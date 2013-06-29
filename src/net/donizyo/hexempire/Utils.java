package net.donizyo.hexempire;

import java.nio.charset.Charset;

public class Utils {
	public static final boolean DEBUG = false;
	public static final long DELAY_LONG = 100l;
	public static final long DELAY_SHORT = 10l;
	public static final long TIMEOUT = 10000l;
	public static final Charset CHARSET = Charset.forName("GBK");
	
    public static int parseHexInt(String s) {
    	int result = 0;
    	boolean negative = false;
    	int i = 0, len = s.length();
    	int shift = 10;
    	char digit;
    	if (len > 0) {
    		char firstChar = s.charAt(0);
    		if (firstChar < '0') {
    			if (firstChar == '-') {
    				negative = true;
    			} else if (firstChar != '+')
    				throw new NumberFormatException();
    			i++;
    		}
    		int num = 0;
        	for (;i < len;) {
        		digit = s.charAt(i++);
        		if (digit >= '0' && digit <= '9')
        			num = digit - '0';
        		else if (digit >= 'a' && digit <= 'f')
        			num = digit - 'a' + shift;
        		else if (digit >= 'A' && digit <= 'F')
        			num = digit - 'A' + shift;

        		result <<= Communication.HEXLEN;
        		result += num;
        	}
    	}
    	return negative ? -result : result;
    }

    public static class CPointer {
    	
    }
}

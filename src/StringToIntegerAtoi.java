public class StringToIntegerAtoi {
	public int myAtoi(String s) {
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index == s.length()) {
            return 0;
        }
        
        boolean isNegative = false;
        if (s.charAt(index) == '-') {
            isNegative = true;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }
        if (index == s.length()) {
            return 0;
        }
        
        if (!Character.isDigit(s.charAt(index))) {
            return 0;
        } 
        int start = index;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            index++;
        }

        int result;
        try {
            result = Integer.parseInt(s.substring(start, index));
        } catch (NumberFormatException e) {
            if (isNegative) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        
        if (isNegative) {
            result = -result;
        }
        return result;
    }
}

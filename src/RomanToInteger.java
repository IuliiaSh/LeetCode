public class RomanToInteger {
	public int romanToInt(String s) {
        int result = 0;
        int previous = getIntegerFromRoman(s.charAt(0));
        int current;
        for (int i = 1; i < s.length(); i++) {
            current = getIntegerFromRoman(s.charAt(i));
            if ((previous == 1 && (current == 5 || current == 10)) ||
                    (previous == 10 && (current == 50 || current == 100)) ||
                    (previous == 100 && (current == 500 || current == 1000))) {
                result = result - previous + current;
                previous = 0;
            } else {
                result = result + previous;
                previous = current;
            }       
        }
        result = result + previous;
        return result;
    }
    
    private int getIntegerFromRoman(char c) {
        switch(c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

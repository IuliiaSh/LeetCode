public class ReverseInteger {
	public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }
        
        int result = 0;
        while (x > 0) {
            try {
            result = Math.addExact(Math.multiplyExact(result, 10), x % 10);
            } catch (java.lang.ArithmeticException e) {
                return 0;
            }
            x = x / 10;
        }
        
        if (isNegative) {
            result = -result;
        }
        return result;
    }
}

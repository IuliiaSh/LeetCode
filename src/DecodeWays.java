public class DecodeWays {
	public int numDecodings(String s) {
		int[] result = new int[s.length() + 1];
        result[s.length()] = 1;
        if (s.charAt(s.length() - 1) != '0') {
            result[s.length() - 1] = 1;
        }
        
        for (int i = s.length() - 2; i >=0; i--) {
            if (s.charAt(i) != '0') {
            	result[i] = result[i] + result[i + 1];
            }
            
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
            	result[i] = result[i] + result[i + 2];
            }
        }
        return result[0];
    }
}

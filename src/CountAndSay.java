public class CountAndSay {
	public String countAndSay(int n) {
        StringBuilder result = new StringBuilder("1");
        n--;
        StringBuilder nextResult; 
        char currentChar;
        int currentCount;
        while (n > 0) {
            n--;
            nextResult = new StringBuilder();
            currentCount = 1;
            currentChar = result.charAt(0);
            for (int i = 1; i < result.length(); i++) {
                if (result.charAt(i) == currentChar) {
                    currentCount++;
                } else {
                    nextResult.append(currentCount);
                    nextResult.append(currentChar);
                    currentCount = 1; 
                    currentChar = result.charAt(i);
                }
            }
            nextResult.append(currentCount);
            nextResult.append(currentChar);
            result = nextResult;
        }
        return result.toString();
    }
}

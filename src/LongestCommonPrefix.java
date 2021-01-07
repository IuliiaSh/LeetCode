public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0) return "";

        int i = 0;
        boolean isEnd = false;
        Character neededChar;
        Character currentChar;
        while (i < strs[0].length() && !isEnd) {
            neededChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++)
            {
                if (strs[j].length() == i) {
                    isEnd = true;
                    break;
                }
                
                currentChar = strs[j].charAt(i);
                if (currentChar != neededChar)
                {
                    isEnd = true;
                    break;
                }
            }
            if (!isEnd) i++;
        }
        return strs[0].substring(0, i);
    }
}
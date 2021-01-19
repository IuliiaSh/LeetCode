public class ImplementStrStr {
	public int strStr(String haystack, String needle) {
        boolean isFound;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            isFound = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    isFound = false;
                    break;
                }
            }
            
            if (isFound) {
                return i;
            }
        }
        return -1;
    }
}

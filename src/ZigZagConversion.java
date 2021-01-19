public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        int j = 0;
        boolean isGoUp = true;
        for (int i = 0; i < s.length(); i++) {
            rows[j].append(s.charAt(i));
            
            if (isGoUp) {
                if (j < numRows - 1) {
                    j++;
                } else {
                    j--;
                    isGoUp = false;
                }
            } else {
                if (j > 0) {
                    j--;
                } else {
                    j++;
                    isGoUp = true;
                }
            }
        }
        
        for (int i = 1; i < numRows; i++) {
            rows[0].append(rows[i]);
        }
        return rows[0].toString();
    }
}

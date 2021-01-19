import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        int openNumber = 0;
        int closedNumber = 0;
        StringBuilder sb = new StringBuilder();
        generateParenthesis(n, openNumber, closedNumber, sb, result);
        return result;
    }
    
    private void generateParenthesis(int n, int openNumber, int closedNumber, StringBuilder sb, List<String> result) {
        if (sb.length() == 2*n) {
            result.add(sb.toString());
            return;
        }
        
        if (openNumber < n) {
            sb.append("(");
            openNumber++;
            generateParenthesis(n, openNumber, closedNumber, sb, result);
            sb.deleteCharAt(sb.length() - 1);
            openNumber--;
        }
        
        if (openNumber > closedNumber) {
            sb.append(")");
            closedNumber++;
            generateParenthesis(n, openNumber, closedNumber, sb, result);
            sb.deleteCharAt(sb.length() - 1);
            closedNumber--;
        }
    }
}

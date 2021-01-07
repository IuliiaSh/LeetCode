import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        
        Stack<Character> opens = new Stack<Character>();
        Character nextInput;
        Character nextOnStack;
        for (int i = 0; i < s.length(); i++) {
            nextInput = s.charAt(i);
            switch(nextInput) {
                case '(':
                case '{':
                case '[':
                    opens.push(nextInput);
                    break;
                case ')':
                    if (opens.empty()) return false;
                    nextOnStack = opens.pop();
                    if (nextOnStack != '(') return false;
                    break;
                case '}':
                    if (opens.empty()) return false;
                    nextOnStack = opens.pop();
                    if (nextOnStack != '{') return false;
                    break;
                case ']':
                    if (opens.empty()) return false;
                    nextOnStack = opens.pop();
                    if (nextOnStack != '[') return false;
                    break;
            }               
        }
        
        if (opens.empty()) return true;
        return false;
    }
}

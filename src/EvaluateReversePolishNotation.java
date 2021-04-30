import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
        int a;
        int b;
        for (int i = 0; i < tokens.length; i++) {
            switch(tokens[i]) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b + a);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b * a);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
                }
        }
        return stack.pop();
    }
}

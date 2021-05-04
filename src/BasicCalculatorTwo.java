import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BasicCalculatorTwo {
	public int calculate(String s) {
		s = s.replaceAll("\\s+","");
        int start = 0;
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        LinkedList<Character> operators = new LinkedList<Character>();
        int nextIntEnd;
        int nextInt;
        while (start < s.length()) {
            switch(s.charAt(start)) {
                case ('+'):
                case ('-'):
                    operators.addLast(s.charAt(start));
                    start++;
                    break;
                case '*':
                    nextIntEnd = getNextIntEnd(s, start + 1);
                    nextInt = Integer.parseInt(s.substring(start + 1, nextIntEnd));
                    numbers.addLast(numbers.removeLast() * nextInt);
                    start = nextIntEnd;
                    break;
                case '/':
                    nextIntEnd = getNextIntEnd(s, start + 1);
                    nextInt = Integer.parseInt(s.substring(start + 1, nextIntEnd));
                    numbers.addLast(numbers.removeLast() / nextInt);
                    start = nextIntEnd;
                    break;
                default:
                    nextIntEnd = getNextIntEnd(s, start);
                    nextInt = Integer.parseInt(s.substring(start, nextIntEnd));
                    numbers.addLast(nextInt);
                    start = nextIntEnd;
                    break;
            }
        }
        
        char nextOperator;
        int firstNumber;
        int secondNumber;
        while (!operators.isEmpty()) {
            nextOperator = operators.removeFirst();
            firstNumber = numbers.removeFirst();
            secondNumber = numbers.removeFirst();
            switch(nextOperator) {
                case ('+'):
                    numbers.addFirst(firstNumber + secondNumber);
                    break;
                case ('-'):
                    numbers.addFirst(firstNumber - secondNumber);
                    start++;
                    break;
            }
        }
        return numbers.remove();
    }
    
    private int getNextIntEnd(String s, int index) {
        int start = index;
        int end = start;
        Set<Character> operators = new HashSet<Character>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');
        while (end < s.length() && !operators.contains(s.charAt(end))) {
            end++;
        }
        return end;
    }
}

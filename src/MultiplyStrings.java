import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) return "0";
		
        List<StringBuilder> results = new ArrayList<StringBuilder>();
        StringBuilder currentResult;
        for (int i = 0; i < num2.length(); i++) {
            currentResult = multiplyDigit(new StringBuilder(num1), Character.getNumericValue(num2.charAt(i)));
            for (int j = 0; j < num2.length() - i - 1; j++) {
                currentResult.append('0');
            }
            results.add(new StringBuilder(currentResult));
        }

        StringBuilder result = results.get(0);
        for (int i = 1; i < results.size(); i++) {
            result = addNumber(result, results.get(i));
        }
        return result.toString();
    }
    
    private StringBuilder multiplyDigit(StringBuilder num1, int digit) {
        StringBuilder result = new StringBuilder();
        num1 = num1.reverse();
        int reminder = 0;
        int currentResult;
        int i = 0;
        while (i < num1.length()) {
            currentResult = Character.getNumericValue(num1.charAt(i)) * digit + reminder;
            result.append(currentResult % 10);
            reminder = currentResult / 10;
            i++;
        }
        
        while (reminder > 0) {
            result.append(reminder % 10);
            reminder = reminder / 10;
        }
        return result.reverse();
    }
    
    private StringBuilder addNumber(StringBuilder num1, StringBuilder num2) {
        StringBuilder result = new StringBuilder();
        num1 = num1.reverse();
        num2 = num2.reverse();
        int reminder = 0;
        int currentResult;
        int i = 0;
        while (i < num1.length() && i < num2.length()) {
            currentResult = Character.getNumericValue(num1.charAt(i)) + 
                Character.getNumericValue(num2.charAt(i)) + reminder;
            result.append(currentResult % 10);
            reminder = currentResult / 10;
            i++;
        }
        
        while (i < num1.length()) {
            currentResult = Character.getNumericValue(num1.charAt(i)) + reminder;
            result.append(currentResult % 10);
            reminder = currentResult / 10;
            i++;
        }
        
        while (i < num2.length()) {
            currentResult = Character.getNumericValue(num2.charAt(i)) + reminder;
            result.append(currentResult % 10);
            reminder = currentResult / 10;
            i++;
        }
        
        if (reminder != 0) {
            result.append(reminder);
        }
        return result.reverse();
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
    	StringBuilder result = new StringBuilder();
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) result.append('-');
        Long num = Math.abs((long) numerator);
        Long denom = Math.abs((long) denominator);
        
        long reminder;
        long next;
        if (num > denom) {
            next = num / denom;
            reminder = num - next * denom;
        } else {
            next = 0;
            reminder = num;
        }
        result.append(next);
        
        if (reminder != 0) result.append('.');
        
        Map<Long, Integer> reminders = new HashMap<Long, Integer>();
        List<Long> results = new ArrayList<Long>();
        int i = 0;
        while (reminder != 0) {
        	if (reminders.containsKey(reminder)) {
        		int repetitionStart = reminders.get(reminder);
                for (int j = 0; j < repetitionStart; j++) {
                	result.append(results.get(j));
                }
                
                result.append('(');
                for (int j = repetitionStart; j < results.size(); j++) {
                	result.append(results.get(j));
                }
                result.append(')');
                return result.toString();
        	}
        	
        	reminders.put(reminder, i);
            reminder = reminder * 10;
            next = reminder / denom;
            results.add(next);
            reminder = reminder - next * denom;
            i++;
        }
        
        for (int j = 0; j < results.size(); j++) {
        	result.append(results.get(j));
        }
        return result.toString();
    }
}

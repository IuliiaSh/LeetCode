import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	int pointCount = 3;
    int partLength = 3;
    int maxValue = 255;
    
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        int index = 0;
        int currentPointCount = 0;
        StringBuilder currentInteger = new StringBuilder();
        StringBuilder currentResult = new StringBuilder();
        restoreIpAddressesRecursively(s, index, currentPointCount, currentInteger, currentResult, result);
        return result;
    }
    
    private void restoreIpAddressesRecursively(String s, int index, int currentPointCount,
    		StringBuilder currentInteger, StringBuilder currentResult, List<String> result) {
        if (currentResult.length() + currentInteger.length() == s.length() + pointCount) {
        	result.add(currentResult.toString() + currentInteger.toString());
            return;
        }
        if (index == s.length()) return;

        currentInteger.append(s.charAt(index));
        if (currentInteger.length() == 1 || currentInteger.length() <= partLength && 
        		Character.getNumericValue(currentInteger.charAt(0)) != 0 && Integer.parseInt(currentInteger.toString()) <= maxValue) {
            restoreIpAddressesRecursively(s, index + 1, currentPointCount, currentInteger, currentResult, result); 
        }
        currentInteger.deleteCharAt(currentInteger.length() - 1);

        if (currentPointCount < pointCount && currentInteger.length() > 0) {
        	currentResult.append(currentInteger);
            currentResult.append('.');
            restoreIpAddressesRecursively(s, index, currentPointCount + 1, new StringBuilder(), currentResult, result);
            currentResult.delete(currentResult.length() - currentInteger.length() - 1, currentResult.length());
        }
    }
}
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> currentPath = new Stack<String>();
        String [] steps = path.split("\\/");
        String currentStep;
        for (int i = 0; i < steps.length; i++) {
            currentStep = steps[i];
            if (currentStep.isEmpty()) continue;
            if (currentStep.equals(".")) continue;
            
            if (currentStep.equals("..")) {
                if (!currentPath.empty()) {
                    currentPath.pop();
                }
                
            } else {
                currentPath.push(currentStep);
            }
        }
        if (currentPath.empty()) return "/";
        
        Stack<String> reversePath = new Stack<String>();
        while(currentPath.size() > 0) {
            reversePath.push(currentPath.pop());
        }

        StringBuilder result = new StringBuilder();
        while(reversePath.size() > 0) {
            result.append('/');
            result.append(reversePath.pop());
        }
        return result.toString();
    }
}

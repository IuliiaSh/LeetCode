import java.util.Stack;

public class CourseScheduleTwo {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            nodes[prerequisites[i][1]].neighbors.add(nodes[prerequisites[i][0]]);
        }
        
        boolean hasCycle = checkCycle(numCourses, nodes);
        if (hasCycle) {
        	return new int[0];
        }
        
        Stack<Node> reversedResult = new Stack<Node>();
        boolean[] isVisited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!isVisited[i]) {
            	visit(nodes[i], reversedResult, isVisited);
            }
        }
        
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = reversedResult.pop().val;          
        }
        return result;
    }
	
	private boolean checkCycle(int numCourses, Node[] nodes) {
		boolean[] isVisited = new boolean[numCourses];
        boolean[] isOnStack = new boolean[numCourses];
        boolean isCycle;
        for (int i = 0; i < numCourses; i++) {
            if (!isVisited[i]) {
            	isCycle = checkCycle(nodes[i], isOnStack, isVisited);
                if (isCycle) {
                	return true;
                }
            }
        }
        return false;
	}
    
    private boolean checkCycle(Node root, boolean[] isOnStack, boolean[] isVisited) {  
        isVisited[root.val] = true;
        isOnStack[root.val] = true;
        boolean isCycle;
        for (Node neighbor : root.neighbors) {            	
        	if (isOnStack[neighbor.val]) return true;

        	isCycle = checkCycle(neighbor, isOnStack, isVisited);
        	if (isCycle) return true;
        }
        isOnStack[root.val] = false;
        return false;
    }
    
    private void visit(Node node, Stack<Node> reversedResult, boolean[] isVisited) {
    	isVisited[node.val] = true;
    	for (Node neighbor : node.neighbors) {            	
        	if (!isVisited[neighbor.val]) {
        		visit(neighbor, reversedResult, isVisited);
        	}
        }
    	reversedResult.push(node);
    }
}

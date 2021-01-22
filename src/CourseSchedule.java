public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            nodes[prerequisites[i][0]].neighbors.add(nodes[prerequisites[i][1]]);
        }
        
        boolean[] isVisited = new boolean[numCourses];
        boolean[] isOnStack = new boolean[numCourses];
        boolean isCycle;
        for (int i = 0; i < numCourses; i++) {
            if (!isVisited[i]) {
            	isOnStack[nodes[i].val] = true;
            	isCycle = checkCycle(nodes[i], isOnStack, isVisited);
                if (isCycle) {
                	return false;
                }
            }
        }
        return true;
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
}

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
	public Node connect(Node root) {
        if (root == null) return root;
        
        Queue<Node> previousLevel = new LinkedList<Node>();
        previousLevel.add(root);
        Queue<Node> currentLevel;
        Node currentNode;
        while (previousLevel.peek() != null) {
            currentLevel = new LinkedList<Node>();
            while (!previousLevel.isEmpty()) {
                currentNode = previousLevel.remove();
                currentNode.next = previousLevel.peek();
                currentLevel.add(currentNode.left);
                currentLevel.add(currentNode.right);
            }
            previousLevel = new LinkedList<Node>(currentLevel);
        }
        return root;
    }
}
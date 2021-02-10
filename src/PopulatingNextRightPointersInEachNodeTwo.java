import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeTwo {
	public Node connect(Node root) {
        if (root == null) return root;
        
        Queue<Node> previousLevel = new LinkedList<Node>();
        previousLevel.add(root);
        Queue<Node> currentLevel;
        Node currentNode;
        while (!previousLevel.isEmpty()) {
            currentLevel = new LinkedList<Node>();
            while (!previousLevel.isEmpty()) {
                currentNode = previousLevel.remove();
                currentNode.next = previousLevel.peek();
                if (currentNode.left != null) currentLevel.add(currentNode.left);
                if (currentNode.right != null) currentLevel.add(currentNode.right);
            }
            previousLevel = new LinkedList<Node>(currentLevel);
        }
        return root;
    }
}

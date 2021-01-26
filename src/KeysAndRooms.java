import java.util.List;
import java.util.Stack;

public class KeysAndRooms {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> roomsToVisit = new Stack<Integer>();
        boolean[] isVisited = new boolean[rooms.size()];
        roomsToVisit.push(0);
        int visitedNumber = 1;
        int current;
        while (!roomsToVisit.empty() && visitedNumber < rooms.size()) {
            current = roomsToVisit.pop();
            if (!isVisited[current]) {
                isVisited[current] = true;
                for (int next : rooms.get(current)) {
                    if (!isVisited[next]) {
                    	roomsToVisit.push(next);
                        visitedNumber++;
                    }
                }
            }
        }
        
        if (visitedNumber < rooms.size()) return false;
        return true;
    }
}

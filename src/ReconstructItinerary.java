import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {
	public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> destinations = new HashMap<String, List<String>>();
        Map<String, Integer> availableTickets = new HashMap<String, Integer>();
        String from;
        String to;
        String from_to;
        for (List<String> ticket : tickets) {
            from = ticket.get(0);
            to = ticket.get(1);
            if (!destinations.containsKey(from)) {
                destinations.put(from, new ArrayList<String>());
            }
            destinations.get(from).add(to);
            
            from_to = from + "_" + to;
            if (!availableTickets.containsKey(from_to)) {
            	availableTickets.put(from_to, 0);
            }
            availableTickets.put(from_to, availableTickets.get(from_to) + 1);
        } 
        for (Map.Entry<String, List<String>> destination : destinations.entrySet()) {
        	Collections.sort(destination.getValue());
        }
        
        int tripLength = tickets.size() + 1;
        List<String> currentResult = new ArrayList<String>();
        currentResult.add("JFK");
        return findItinerary(destinations, availableTickets, tripLength, currentResult);
    }
    
    private List<String> findItinerary(Map<String, List<String>> destinations, Map<String, Integer> availableTickets,
    		int tripLength, List<String> currentResult) {
        if (currentResult.size() == tripLength) return new ArrayList<String>(currentResult);
        
        List<String> tos = destinations.get(currentResult.get(currentResult.size() - 1));
        if (tos == null) return null;
        
        List<String> result;
        String from_to;
        for (String to : tos) {
        	from_to = currentResult.get(currentResult.size() - 1) + "_" + to;
        	if (availableTickets.get(from_to) > 0) {
	            currentResult.add(to);
	            availableTickets.put(from_to, availableTickets.get(from_to) - 1);
	            result = findItinerary(destinations, availableTickets, tripLength, currentResult);
	            currentResult.remove(currentResult.size() - 1);
	            availableTickets.put(from_to, availableTickets.get(from_to) + 1);
	            
	            if (result != null) return result;
        	}
        }
        return null;
    }
}
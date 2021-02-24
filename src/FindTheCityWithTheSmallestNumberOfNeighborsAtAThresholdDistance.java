import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        City[] cities = new City[n];
        for (int i = 0; i < n; i++) {
            cities[i] = new City(i);
        }

        Road road;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][2] <= distanceThreshold) {
            	road = new Road(edges[i][0], edges[i][1], edges[i][2]);
            	cities[edges[i][0]].roads.add(road);
            	cities[edges[i][1]].roads.add(road);
            }
        }
        
        int result = -1;
        int reachableNumber = Integer.MAX_VALUE;
        int[] currentReachableNumber = new int[1];
        TreeMap<Integer, List<Integer>> nextCities;
        boolean[] isVisited;
        for (int i = 0; i < n; i++) {
        	currentReachableNumber[0] = 0;
            nextCities = new TreeMap<Integer, List<Integer>>();
            List<Integer> entry = new ArrayList<Integer>();
            entry.add(i);
            nextCities.put(0, entry);
            isVisited = new boolean[n];
            while (!nextCities.isEmpty()) {
            	visitCity(distanceThreshold, currentReachableNumber, cities, nextCities, isVisited);
            } 
            
            if (currentReachableNumber[0] <= reachableNumber) {
            	result = i;
            	reachableNumber = currentReachableNumber[0];  
            }
        }
        return result;
    }

	private void visitCity(int distanceThreshold, int[] currentReachableNumber,
			City[] cities, TreeMap<Integer, List<Integer>> nextCities, boolean[] isVisited) {
		Map.Entry<Integer, List<Integer>> entry = nextCities.firstEntry();
		int distance = entry.getKey();
		City city = cities[entry.getValue().remove(0)];
		if (entry.getValue().isEmpty()) {
			nextCities.pollFirstEntry();
		}
		
		if (isVisited[city.number]) return;
		isVisited[city.number] = true;
		currentReachableNumber[0]++;
		
		int otherCityDistance;
		int otherCityNumber; 
		for (Road r : city.roads) {
			otherCityNumber = r.getOther(city.number);
			otherCityDistance = distance + r.weight;
		    if (otherCityDistance <= distanceThreshold) {
		    	if (!nextCities.containsKey(otherCityDistance)) {
		    		nextCities.put(otherCityDistance, new ArrayList<Integer>());
		    	}
		        nextCities.get(otherCityDistance).add(otherCityNumber);
		    }
		}
	}
}

class City {
	int number;
    public List<Road> roads;

    public City(int number) {
    	this.number = number;
        this.roads = new ArrayList<Road>();
    }
}

class Road {
    int first;
    int second;
    int weight;
    
    public Road(int first, int second, int weight) {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }
    
    public int getOther(int city) {
        if (city == first) return second;
        return first;
    }
}

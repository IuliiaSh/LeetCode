import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilterRestaurantsByVeganFriendlyPriceAndDistance {
	public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(restaurants, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
            	if (Integer.compare(o2[1], o1[1]) != 0) return Integer.compare(o2[1], o1[1]);
                return Integer.compare(o2[0], o1[0]);
            }
        });
        
        Set<Integer> vegan = new HashSet<Integer>();
        vegan.add(1);
        if (veganFriendly == 0) vegan.add(0);
        for (int i = 0; i < restaurants.length; i++) {
            if (vegan.contains(restaurants[i][2]) && restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance) {
                result.add(restaurants[i][0]);
            }
        }
        return result;
    }
}
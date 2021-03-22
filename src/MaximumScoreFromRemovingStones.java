public class MaximumScoreFromRemovingStones {
	public int maximumScore(int a, int b, int c) {
        int biggest = Math.max(a, Math.max(b, c));
        int smallest = Math.min(a, Math.min(b, c));
        int middle;
        if (smallest < a && a < biggest) {
            middle = a;
        } else if (smallest < b && b < biggest) {
            middle = b;
        } else {
            middle = c;
        }
        
        if (biggest >= middle + smallest) {
            return smallest + middle;
        } else {
            return (a + b + c) / 2; 
        }
    }
}

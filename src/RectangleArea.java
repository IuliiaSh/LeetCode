public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int firstArea = (C - A) * (D - B);
        int secondArea = (G - E) * (H - F);
        
        int result = firstArea + secondArea;;
        if (E > C || A > G || B > H || F > D) {
            
        } else {
            int x_max = Math.min(G, C);
            int x_min = Math.max(A, E);
            int y_max = Math.min(D, H);
            int y_min = Math.max(B, F);
            result = result - (x_max - x_min) * (y_max - y_min);
        }
        return result;
    }
}

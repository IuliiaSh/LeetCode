import java.util.Arrays;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] numberToSize = new int[n + 1];
        Arrays.fill(numberToSize, 1);
        int nextNumber;
        for (int i = 2; i <= n; i++) {
            nextNumber = 0;
            for (int j = 1; j <= i; j++) {
                nextNumber += numberToSize[j - 1] * numberToSize[i - j];
            }
            numberToSize[i] = nextNumber;
        }
        return numberToSize[n];
    }
}

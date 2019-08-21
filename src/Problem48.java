import java.util.Arrays;

public class Problem48 {

    public static void main(String... args) {
        int[][] test1 = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] test2 = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};

        Solution sol = new Problem48().new Solution();
        for (int[] row : test1) {
            System.out.println(Arrays.toString(row));
        }
        sol.rotate(test1);
        System.out.println();
        for (int[] row : test1) {
            System.out.println(Arrays.toString(row));
        }

    }

    class Solution {
        public void rotate(int[][] matrix) {
            int xlim = matrix.length/2;
            int ylim = matrix.length/2;
            if(matrix.length%2==1){
                xlim++;
            }
            for (int x = 0; x < xlim; x++) {
                for (int y = 0; y < ylim; y++) {
                    if (matrix.length % 2 == 1 && x == matrix.length / 2 && y == matrix.length / 2) {
                        continue;
                    }
                    int cx = x, cy = y;
                    int pval = matrix[cy][cx];
                    for (int i = 0; i < 4; i++) {
                        //System.out.print(cx+", "+cy+" -> ");
                        //update to next cx, cy
                        int temp = cy;
                        cy = cx;
                        cx = matrix.length - 1 - temp;
                        int val = matrix[cy][cx];
                        matrix[cy][cx] = pval;
                        pval = val;
                    }
                    //System.out.println();

                }
            }
        }
    }
}

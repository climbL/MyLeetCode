import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _73_矩阵置零 {

    /**
     * 使用额外空间存储0元素的行号、列号
     */
    class Solution {
        public void setZeroes(int[][] matrix) {
            Set<Integer> hang = new HashSet<>();    // 可以把Set换成数组，下标表示行号/列号
            Set<Integer> lie = new HashSet<>();
            int m = matrix.length;
            int n = matrix[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        hang.add(i);
                        lie.add(j);
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (hang.contains(i) || lie.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }

    /**
     * 使用第一行、第一列来记录，不使用额外空间，空间复杂度为O(1)
     * 用两个变量记录第一行、列是否有零，然后先用其他行和列更新第一行、列，然后用第一行、列更新其他行、列
     * 最后第一行、列是否有零，更新第一行、列的值即可。
     */
    class Solution {
        public void setZeroes(int[][] matrix) {
            boolean hang0 = false;
            boolean lie0 = false;
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    hang0 = true;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    lie0 = true;
                }
            }

            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if(hang0){
                Arrays.fill(matrix[0], 0);
            }
            if(lie0){
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }


}

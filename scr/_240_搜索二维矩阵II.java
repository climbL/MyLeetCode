public class _240_搜索二维矩阵II {

    /**
     * 每行都使用二分查找 O(mlogn)
     */
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            for (int i = 0; i < matrix.length; i++) {
                int l = 0, r = matrix[0].length - 1, m;
                while (l <= r) {
                    m = (r - l) / 2 + l;
                    if (matrix[i][m] == target) {
                        return true;
                    } else if (matrix[i][m] > target) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
            }
            return false;
        }
    }

    /**
     * Z 字形查找:时间复杂度O(m+n)
     * 从矩阵matrix 的右上角(0,n−1)向左下角(m-1,0)进行搜索.
     * 在搜索的过程中，如果超出了矩阵的边界，那么说明矩阵中不存在target
     * (每次排除一行或者一列)
     */
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int x = 0, y = matrix[0].length-1;
            while(x<matrix.length && y>=0){
                if(matrix[x][y]==target){
                    return true;
                }else if(matrix[x][y]>target){
                    y--;
                }else{
                    x++;
                }
            }
            return false;
        }
    }


}

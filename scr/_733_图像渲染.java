public class _733_图像渲染 {
    /**
     * DFS
     */
    class Solution {
        public int[][] image;
        public int newColor;
        public byte[][] used;
        public int oldColor;
        public int[][] floodFill(int[][] _image, int sr, int sc, int _newColor) {
            image = _image;
            newColor = _newColor;
            used = new byte[image.length][image[0].length];
            oldColor = image[sr][sc];
            fill(sr, sc);
            return image;
        }

        public void fill(int sr, int sc) {
            image[sr][sc] = newColor;
            used[sr][sc] = 1;
            if (sr - 1 >= 0 && used[sr - 1][sc] != 1 && image[sr - 1][sc]==oldColor) {
                fill(sr - 1, sc);
            }
            if (sr + 1 < image.length && used[sr + 1][sc] != 1 && image[sr + 1][sc]==oldColor) {
                fill(sr + 1, sc);
            }
            if (sc - 1 >= 0 && used[sr][sc - 1] != 1 && image[sr][sc - 1]==oldColor) {
                fill(sr, sc - 1);
            }
            if (sc + 1 < image[0].length && used[sr][sc + 1] != 1 && image[sr][sc + 1]==oldColor) {
                fill(sr, sc + 1);
            }
        }
    }


}

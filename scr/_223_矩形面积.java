import java.util.Random;

public class _223_矩形面积 {

    class Solution {
        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            int max = 10000000;
            int x1 = Math.min(Math.min(Math.min(ax1, bx1), ax2), bx2);
            int y1 = Math.min(Math.min(Math.min(ay1, by1), ay2), by2);
            int x2 = Math.max(Math.max(Math.max(ax1, bx1), ax2), bx2);
            int y2 = Math.max(Math.max(Math.max(ay1, by1), ay2), by2);
            System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
            Random r_x = new Random(0);
            Random r_y = new Random(1);
            double p = 0;
            for (int i = 0; i < max; i++) {
                double _x = r_x.nextDouble();
                double _y = r_y.nextDouble();
                double k1 = ((double) (x2 + 1)) / x1 - 1;
                double k2 = ((double) (y2 + 1)) / y1 - 1;
                if(_x<k1 && _y<k2){
                    p++;
                }
            }
            p = p / max;
            return (int) p * (x2 - x1) * (y2 - y1);
        }
    }


}

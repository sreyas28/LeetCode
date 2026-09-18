public class ProblemNo1401 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1401().new Solution();
        System.out.println(a.checkOverlap(1, 0, 0, 1, -1, 3, 1));
        System.out.println(a.checkOverlap(1, 1, 1, 1, -3, 2, -1));
        System.out.println(a.checkOverlap(4, 9, 3, 1, 5, 2, 10));
        System.out.println(a.checkOverlap(3,0,0, 5,0,0,5));
        System.out.println(a.checkOverlap(3,0,0, 5,0,3,5));
        System.out.println(a.checkOverlap(10,0,0, 8,8, 16,16));
        System.out.println(a.checkOverlap(10,0,0, 6,8, 16,16));

    }

    class Solution {
        static class Circle {
            int radius, x, y;

            Circle(int radius, int x, int y) {
                this.radius = radius;
                this.x = x;
                this.y = y;
            }

            public boolean inside(int i, int j) {
                double val = Math.pow(i - x, 2) + Math.pow(y - j, 2);
                return val <= ((long) radius * radius);
            }
        }

        public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
            Circle circle = new Circle(radius, xCenter, yCenter);

            int minX = 0, minY = 0;

            if (x1 <= xCenter && xCenter <= x2) {
                minX = xCenter;

                if (yCenter > y2) minY = y2;
                else if (yCenter < y1 ) minY = y1;
                else return true;
            }
            else if (y1 <= yCenter && yCenter <= y2) {
                minY = yCenter;

                if (xCenter > x2) minX = x2;
                else if (xCenter < x1) minX = x1;
                else return true;
            }
            else {
                if (yCenter > y2) minY = y2;
                else if (yCenter < y1 ) minY = y1;
                else return true;

                if (xCenter > x2) minX = x2;
                else if (xCenter < x1) minX = x1;
                else return true;
            }


            return circle.inside(minX, minY);
        }
    }


    // Mad man way to do (Incomplete)
    class Solution_ {
        static class Circle {
            int radius, x, y;

            Circle(int radius, int x, int y) {
                this.radius = radius;
                this.x = x;
                this.y = y;
            }

            public boolean inside(int i, int j) {
                double val = Math.pow(i - x, 2) + Math.pow(y - j, 2);
                return val <= ((long) radius * radius);
            }
        }

        public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
            int[][] rectangle = {{x1, y1}, {x2, y2}, {x1, y2}, {x2, y1}};
            Circle circle = new Circle(radius, xCenter, yCenter);

            // for any edge of rectangle inside the Circle
            for (int[] i : rectangle) {
                if (circle.inside(i[0], i[1])) return true;
            }

            // x1 < xCenter < x2
            // y1 < yCenter < y2
            // if center is inside the Rectangle
            if (x1 <= xCenter && xCenter <= x2 && y1 <= yCenter && yCenter < y2) return true;


            // if above fail another thing is
            // x1 < xCenter ∓ radius < x2
            // y1 < yCenter ∓ radius < y2

            int newXLineCircle_Right = xCenter + radius;
            int newXLineCircle_Left = xCenter - radius;

            int newYLineCircle_Top = yCenter + radius;
            int newYLineCircle_Bottom = yCenter - radius;

            // when circle is smaller then rectangle

            if (
                    (y1 <= newYLineCircle_Bottom && newYLineCircle_Top <= y2) &&
                            ((x1 <= newXLineCircle_Right && newXLineCircle_Right <= x2) ||
                                    (x1 <= newXLineCircle_Left && newXLineCircle_Left <= x2))
            ) return true;

            else if (
                    (x1 <= newXLineCircle_Left && newXLineCircle_Right <= x2) &&
                            ((y1 <= newYLineCircle_Top && newYLineCircle_Top <= y2) ||
                                    (y1 <= newYLineCircle_Bottom && newYLineCircle_Bottom <= y2))
            ) return true;

            // when circle is bigger then the rectangle

            return false;
        }
    }

}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // sanity check
        if (points == null || points.length == 0 || points[0].length != 2 || points.length < k) {
            return null;
        }

        // use max heap to keep track of the k points
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
            public int compare(Point a, Point b) {
                if (a.distance == b.distance) {
                    return 0;
                }
                if (a.distance < b.distance) {
                    return 1;
                }
                return -1;
            }
        });

        // generate points
        List<Point> pointList = toPointList(points);

        // add points to the PQ while maitain the closest k
        for (Point p : pointList) {
            if (pq.size() < k) {
                pq.offer(p);
                continue;
            }

            if (p.distance < pq.peek().distance) {
                pq.poll();
                pq.offer(p);
            }
        }

        // return the points in the q
        int[][] result = new int[k][];
        for (int i = 0; i < result.length; i++) {
            result[i] = pq.poll().point;
        }

        return result;
    }

    private List<Point> toPointList(int[][] points) {
        List<Point> result = new ArrayList<>();
        for (int[] p : points) {
            result.add(new Point(p));
        }
        return result;
    }

    private class Point {
        private int[] point;
        private int distance;

        private Point(int[] point) {
            this.point = point;
            this.distance = point[0] * point[0] + point[1] * point[1];
        }
    }
}

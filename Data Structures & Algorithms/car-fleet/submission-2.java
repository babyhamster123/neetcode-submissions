class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // sanity check
        // assume the constaints all meet per the probelm description 

        // create cars
        List<Car> cars = toCars(position, speed);

        // sort cars by position from far to dest to near
        cars.sort(new Comparator<>(){
            public int compare(Car a, Car b) {
                if (a.position < b.position) {
                    return -1;
                }
                if (a.position == b.position) {
                    return 0;
                }
                return 1;
            }
        });

        // use monotonic stack to keep track of the fleets
        Deque<Car> stack = new ArrayDeque<>();
        for (Car c : cars) {
            // pop the stack to maintain the stack
            while (!stack.isEmpty()) {
                Car top = stack.peekLast();
                if (top.speed <= c.speed) { // can't catch up forever
                    break;
                }

                if (top.timeToDest(target) > c.timeToDest(target)) { // can't catch up before the dest
                    break;
                }

                stack.pollLast();
            }
            
            // push to stack
            stack.offerLast(c);
        }

        return stack.size();
    }

    private List<Car> toCars(int[] position, int[] speed) {
        List<Car> result = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            result.add(new Car(position[i], speed[i]));
        }
        return result;
    }

    private class Car {
        private final int position;
        private final int speed;

        private Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }

        private float timeToDest(int dest) {
            return (float)(dest - position) / speed;
        }
    }
}

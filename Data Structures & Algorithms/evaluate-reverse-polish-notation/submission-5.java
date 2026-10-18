class Solution {
    public int evalRPN(String[] tokens) {
        // sanity check
        // assuming the notation is valid to calculate
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        // use stack to keep track of the nums
        Deque<Integer> stack = new ArrayDeque<>();
        for (String t : tokens) {
            // if operator, pop the top two nums and calculate
            if (isOperator(t)) {
                int num2 =stack.pollLast();
                int num1 = stack.pollLast();
                stack.offerLast(calc(t, num1, num2));
            } else {
                stack.offerLast(Integer.parseInt(t));
            }
        }

        return stack.pollLast();
    }
    
    private boolean isOperator(String token) {
        return token.equals("-") || token.equals("+") || token.equals("*") || token.equals("/");
    }

    private int calc(String operator, int n1, int n2) {
        if (operator.equals("+")) {
            return n1 + n2;
        }

        if (operator.equals("-")) {
            return n1 - n2;
        }

        if (operator.equals("*")) {
            return n1 * n2;
        }

        return n1 / n2;
    }
}

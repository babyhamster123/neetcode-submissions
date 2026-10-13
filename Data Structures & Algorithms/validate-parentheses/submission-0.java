class Solution {
    public boolean isValid(String s) {
        // sanity check
        // assuming s only consists of the 6 brackets 
        if (s == null) {
            return false;
        }

        // use stack to store the open brackets in order
        Deque<Character> stack = new ArrayDeque<>();

        // remove when corresponding closing bracket meets
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }

                return false;
            }
            

            if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                    continue;
                }

                return false;
            }
            
            
            if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                    continue;
                }

                return false;
            }
        }

        return stack.isEmpty();
    }
}

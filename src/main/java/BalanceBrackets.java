import java.util.Stack;

/*
Stacks, Queues, and Lists
3-1. [3] A common problem for compilers and text editors is determining whether the parentheses in a string are
balanced and properly nested. For example, the string ((())())() contains properly nested pairs of parentheses,
which the strings )()( and ()) do not. Give an algorithm that returns true if a string contains properly
nested and balanced parentheses, and false if otherwise. For full credit, identify the position of the
first offending parenthesis if the string is not properly nested and balanced.
 */
public class BalanceBrackets {
    private static final Character OPEN_BRACKET = '(';
    private static final Character CLOSE_BRACKET = ')';

    /**
     * @return -1 for balanced brackets or index of offending bracket
     */
    public static int indexOfUnbalancedBracket(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (c == OPEN_BRACKET) {
                stack.add(c);
            } else if (c == CLOSE_BRACKET) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return i;
                }
            }
        }
        return -1;
    }
}

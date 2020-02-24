import java.util.Objects;
import java.util.Stack;

public class ReverseSinglyList {
    public static ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            stack.add(currentNode.val);
            currentNode = currentNode.next;
        }

        ListNode start = null;
        currentNode = null;
        while (!stack.isEmpty()) {
            if (start == null) {
                start = new ListNode(stack.pop());
                currentNode = start;
            } else {
                currentNode.next = new ListNode(stack.pop());
                currentNode = currentNode.next;
            }
        }
        return start;
    }

    public static String toString(ListNode head) {
        StringBuilder builder = new StringBuilder();
        ListNode currentNode = head;
        while (currentNode != null) {
            builder.append(currentNode.val)
                    .append(",");
            currentNode = currentNode.next;
        }
        return builder.toString();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ListNode listNode = (ListNode) o;

            if (val != listNode.val) return false;
            return Objects.equals(next, listNode.next);
        }
    }
}
import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;

public class ReverseSinglyListTest {
    @Test
    public void empty() {
        assertThat(ReverseSinglyList.reverseList(null)).isEqualTo(null);
    }

    @Test
    public void singleElement() {
        assertThat(ReverseSinglyList.reverseList(new ReverseSinglyList.ListNode(2))).isEqualTo(new ReverseSinglyList.ListNode(2));
    }

    @Test
    public void singlyList() {
        ReverseSinglyList.ListNode _2 = new ReverseSinglyList.ListNode(2);
        ReverseSinglyList.ListNode _3 = new ReverseSinglyList.ListNode(3);
        ReverseSinglyList.ListNode _4 = new ReverseSinglyList.ListNode(4);
        ReverseSinglyList.ListNode _5 = new ReverseSinglyList.ListNode(5);
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;

        ReverseSinglyList.ListNode r_2 = new ReverseSinglyList.ListNode(2);
        ReverseSinglyList.ListNode r_3 = new ReverseSinglyList.ListNode(3);
        ReverseSinglyList.ListNode r_4 = new ReverseSinglyList.ListNode(4);
        ReverseSinglyList.ListNode r_5 = new ReverseSinglyList.ListNode(5);
        r_5.next = r_4;
        r_4.next = r_3;
        r_3.next = r_2;

        assertThat(ReverseSinglyList.reverseList(_2)).isEqualTo(r_5);
    }
}
